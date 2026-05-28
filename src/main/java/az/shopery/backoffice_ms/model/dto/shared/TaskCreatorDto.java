package az.shopery.backoffice_ms.model.dto.shared;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskCreatorDto {
    UUID id;
    String name;
    String email;
    String phone;
}
