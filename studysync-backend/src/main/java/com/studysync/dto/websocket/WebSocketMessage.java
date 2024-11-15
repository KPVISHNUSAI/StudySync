// websocket/WebSocketMessage.java
package com.studysync.dto.websocket;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class WebSocketMessage {
    private String type;
    private String content;
    private Long sessionId;
    private Long userId;
    private LocalDateTime timestamp;
}