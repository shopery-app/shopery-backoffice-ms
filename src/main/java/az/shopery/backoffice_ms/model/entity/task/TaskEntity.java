package az.shopery.backoffice_ms.model.entity.task;

import az.shopery.model.entity.UserEntity;
import az.shopery.utils.enums.TaskCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "task_category", discriminatorType = DiscriminatorType.STRING)
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class TaskEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    UUID id;
    @Enumerated(EnumType.STRING)
    @Column(name = "task_category", nullable = false, insertable = false, updatable = false)
    TaskCategory taskCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", nullable = false)
    UserEntity createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_admin_id")
    UserEntity assignedAdmin;
    @Builder.Default
    @Column(name = "is_user_notified", nullable = false)
    Boolean isUserNotified = Boolean.FALSE;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    Instant createdAt;
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    Instant updatedAt;
}
