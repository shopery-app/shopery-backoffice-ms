package az.shopery.backoffice_ms.repository;

import az.shopery.backoffice_ms.model.entity.UserEntity;
import az.shopery.backoffice_ms.model.entity.task.TaskEntity;
import az.shopery.backoffice_ms.utils.enums.TaskCategory;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
    @EntityGraph(attributePaths = {"createdBy", "assignedAdmin"})
    Page<TaskEntity> findAllByAssignedAdmin(UserEntity assignedAdmin, Pageable pageable);
    @EntityGraph(attributePaths = {"createdBy", "assignedAdmin"})
    Page<TaskEntity> findAllByAssignedAdminAndTaskCategory(UserEntity assignedAdmin, TaskCategory taskCategory, Pageable pageable);
    Optional<TaskEntity> findByIdAndAssignedAdmin(UUID id, UserEntity assignedAdmin);
}
