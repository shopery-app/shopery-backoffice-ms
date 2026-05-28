package az.shopery.backoffice_ms.model.entity.task;

import az.shopery.backoffice_ms.utils.enums.TicketStatus;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("SUPPORT_TICKET")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupportTicketEntity extends TaskEntity {
    @Column(name = "subject", nullable = false)
    String subject;
    @Column(name = "description", nullable = false)
    String description;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(name = "ticket_status", nullable = false)
    TicketStatus ticketStatus = TicketStatus.OPEN;
}
