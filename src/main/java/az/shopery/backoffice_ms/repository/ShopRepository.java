package az.shopery.backoffice_ms.repository;

import az.shopery.backoffice_ms.model.dto.projection.AdminShopProjection;
import az.shopery.backoffice_ms.model.entity.ShopEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<ShopEntity, UUID> {
    Optional<ShopEntity> findByShopName(String shopName);

    @Query("""
        SELECT
            s.id AS id,
            s.shopName AS shopName,
            s.description AS description,
            s.totalIncome AS totalIncome,
            s.rating AS rating,
            s.createdAt AS createdAt,
            COUNT(p.id) AS totalProducts,
            u.subscriptionTier AS subscriptionTier,
            s.status AS shopStatus,
            u.email AS userEmail,
            u.status AS userStatus
        FROM ShopEntity s
        LEFT JOIN s.user u
        LEFT JOIN s.products p
        GROUP BY
            s.id, s.shopName, s.description, s.totalIncome, s.rating, s.createdAt,
            u.subscriptionTier, s.status, u.email, u.status
    """)
    Page<AdminShopProjection> findAllWithProductCount(Pageable pageable);
}
