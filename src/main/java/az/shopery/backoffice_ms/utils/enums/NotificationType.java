package az.shopery.backoffice_ms.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationType {
    SHOP_APPROVED("shop-creation-approved-email", "Your Shop Creation Request Has Been Approved"),
    SHOP_REJECTED("shop-creation-rejected-email", "Your Shop Creation Request Has Been Rejected");

    private final String templateName;
    private final String subject;
}
