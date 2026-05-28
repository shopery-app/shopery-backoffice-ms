package az.shopery.backoffice_ms.repository;

import az.shopery.model.entity.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistEntity, UUID> {
    @Query("SELECT w FROM WishlistEntity w LEFT JOIN FETCH w.products WHERE w.user.id = :userId")
    Optional<WishlistEntity> findByUserIdWithProducts(@Param("userId") UUID userId);
}
