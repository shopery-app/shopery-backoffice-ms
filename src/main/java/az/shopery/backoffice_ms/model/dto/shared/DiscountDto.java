package az.shopery.backoffice_ms.model.dto.shared;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountDto {
    int percentage;
    BigDecimal originalPrice;
}
