package az.shopery.backoffice_ms.model.entity;

import az.shopery.utils.enums.ProductCategory;
import az.shopery.utils.enums.ProductCondition;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "shop_id", nullable = false)
    ShopEntity shop;
    @Column(name = "product_name", nullable = false)
    String productName;
    @Column(name = "description", length = 2000)
    String description;
    @Column(name = "current_price", precision = 10, scale = 2)
    BigDecimal currentPrice;
    @Column(name = "original_price", precision = 10, scale = 2)
    BigDecimal originalPrice;
    @Column(name = "image_url")
    String imageUrl;
    @Column(name = "stock_quantity", nullable = false)
    Integer stockQuantity;
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    ProductCategory category;
    @Enumerated(EnumType.STRING)
    @Column(name = "condition", nullable = false)
    ProductCondition condition;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<PriceHistoryEntity> priceHistory;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    Instant createdAt;
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    Instant updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
