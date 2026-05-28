package az.shopery.backoffice_ms.repository;

import az.shopery.backoffice_ms.model.entity.UserEntity;
import az.shopery.backoffice_ms.utils.enums.UserRole;
import az.shopery.backoffice_ms.utils.enums.UserStatus;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmailAndUserRoleAndStatus(String email, UserRole userRole, UserStatus status);
    Page<UserEntity> findAllByUserRoleAndStatus(UserRole userRole, UserStatus status, Pageable pageable);
}
