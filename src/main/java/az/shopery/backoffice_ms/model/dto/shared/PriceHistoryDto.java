package az.shopery.backoffice_ms.model.dto.shared;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceHistoryDto {
    BigDecimal price;
    Instant setAt;
}
