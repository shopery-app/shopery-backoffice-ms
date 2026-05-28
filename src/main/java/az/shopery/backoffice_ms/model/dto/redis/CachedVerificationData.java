package az.shopery.backoffice_ms.model.dto.redis;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CachedVerificationData {
    @ToString.Exclude
    String hashedToken;
    @ToString.Exclude
    String userEmail;
    @ToString.Exclude
    String hashedPassword;
    String userName;
    int attemptCount;
    LocalDateTime expiryDate;
    LocalDateTime codeLastSentAt;
}
