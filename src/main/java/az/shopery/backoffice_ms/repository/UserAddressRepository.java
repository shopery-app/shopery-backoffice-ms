package az.shopery.backoffice_ms.repository;

import az.shopery.model.entity.UserAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddressEntity, UUID> {
    List<UserAddressEntity> findAllByUserId(UUID userId);
    boolean existsByUserIdAndIsDefaultTrue(UUID userId);
}
