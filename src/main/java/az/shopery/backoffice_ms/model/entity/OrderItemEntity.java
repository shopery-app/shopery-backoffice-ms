package az.shopery.backoffice_ms.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_items")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    OrderEntity order;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    ProductEntity product;
    @Column(name = "product_name", nullable = false)
    String productName;
    @Column(name = "unit_price", precision = 10, scale = 2, nullable = false)
    BigDecimal unitPrice;
    @Column(name = "quantity", nullable = false)
    Integer quantity;
    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    BigDecimal subtotal;
}
