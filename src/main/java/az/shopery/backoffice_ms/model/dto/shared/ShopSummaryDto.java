package az.shopery.backoffice_ms.model.dto.shared;

import az.shopery.utils.enums.ShopStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopSummaryDto {
    UUID id;
    String shopName;
    ShopStatus status;
}
