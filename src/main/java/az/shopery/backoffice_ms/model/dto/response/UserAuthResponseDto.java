package az.shopery.backoffice_ms.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAuthResponseDto {
    String accessToken;
    String refreshToken;
}
