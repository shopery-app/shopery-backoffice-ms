package az.shopery.backoffice_ms.repository;

import az.shopery.backoffice_ms.model.entity.OrderEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    List<OrderEntity> findAllByShopId(UUID id);
}
