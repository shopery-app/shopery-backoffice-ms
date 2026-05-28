package az.shopery.backoffice_ms.model.dto.redis;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CachedEmailUpdateData {
    @ToString.Exclude
    String code;
    @ToString.Exclude
    String requestedByEmail;
}
