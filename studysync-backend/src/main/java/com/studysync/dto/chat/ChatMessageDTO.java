// chat/ChatMessageDTO.java
package com.studysync.dto.chat;

import com.studysync.dto.user.UserDTO;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ChatMessageDTO {
    private Long id;
    private Long sessionId;
    private UserDTO sender;
    private String message;
    private String messageType;
    private LocalDateTime sentAt;
}