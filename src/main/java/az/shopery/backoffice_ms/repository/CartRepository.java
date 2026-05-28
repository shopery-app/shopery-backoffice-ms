package az.shopery.backoffice_ms.repository;

import az.shopery.model.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, UUID> {
    @Query("SELECT c FROM CartEntity c LEFT JOIN FETCH c.items WHERE c.user.id = :userId")
    Optional<CartEntity> findByUserIdWithItems(@Param("userId") UUID userId);
}
