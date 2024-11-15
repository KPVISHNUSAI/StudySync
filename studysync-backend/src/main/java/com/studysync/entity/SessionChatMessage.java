// SessionChatMessage.java
package com.studysync.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "session_chat_messages")
@Data
public class SessionChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private StudySession session;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String message;

    @Column(name = "message_type")
    private String messageType;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;
}