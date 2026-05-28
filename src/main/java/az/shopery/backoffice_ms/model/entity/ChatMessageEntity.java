package az.shopery.backoffice_ms.model.entity;

import az.shopery.utils.enums.MessageStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "chat_messages")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessageEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    UUID id;

    @Column(name = "sender_id", nullable = false)
    UUID senderId;

    @Column(name = "receiver_id", nullable = false)
    UUID receiverId;

    @Column(name = "content", nullable = false, length = 4000)
    String content;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    MessageStatus status = MessageStatus.SENT;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    Instant createdAt;

    @Column(name = "read_at")
    Instant readAt;
}
