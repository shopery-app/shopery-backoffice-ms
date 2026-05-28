package az.shopery.backoffice_ms.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "shop_ratings", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "shop_id"}))
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopRatingEntity {
    @Id
    @GeneratedValue
    UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    ShopEntity shop;
    @Column(nullable = false)
    Integer rating;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    Instant createdAt;
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    Instant updatedAt;
}
