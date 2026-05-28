package az.shopery.backoffice_ms.model.entity.task;

import az.shopery.utils.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("SUPPORT_TICKET")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
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
