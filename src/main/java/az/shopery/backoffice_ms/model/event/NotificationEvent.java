package az.shopery.backoffice_ms.model.event;

import az.shopery.backoffice_ms.utils.enums.NotificationType;
import java.util.Map;

public record NotificationEvent(
        String to,
        NotificationType type,
        Map<String, Object> params) {
}
