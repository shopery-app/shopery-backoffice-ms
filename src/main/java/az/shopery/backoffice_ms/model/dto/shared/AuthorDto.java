package az.shopery.backoffice_ms.model.dto.shared;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorDto {
    String name;
    String profilePhotoUrl;
}
