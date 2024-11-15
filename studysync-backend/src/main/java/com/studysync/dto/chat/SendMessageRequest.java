// chat/SendMessageRequest.java
package com.studysync.dto.chat;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SendMessageRequest {
    @NotBlank(message = "Message content is required")
    private String message;
    private String messageType;
}
