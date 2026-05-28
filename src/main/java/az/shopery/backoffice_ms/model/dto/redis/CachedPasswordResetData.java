package az.shopery.backoffice_ms.model.dto.redis;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CachedPasswordResetData {
    @ToString.Exclude
    String token;
    @ToString.Exclude
    String userEmail;
    LocalDateTime expiryDate;
    LocalDateTime linkLastSentAt;
}
