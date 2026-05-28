package az.shopery.backoffice_ms.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name = "blog_likes", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "blog_id"}))
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id",  nullable = false)
    UserEntity user;
    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    BlogEntity blog;
    @CreatedDate
    @Column(name = "liked_at", nullable = false, updatable = false)
    Instant likedAt;
}
