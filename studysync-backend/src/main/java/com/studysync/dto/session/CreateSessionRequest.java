// session/CreateSessionRequest.java
package com.studysync.dto.session;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CreateSessionRequest {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    private LocalDateTime scheduledStart;
    private LocalDateTime scheduledEnd;
    private Integer maxParticipants;
    private boolean isPrivate;
    private Long categoryId;
    private String sessionSettings;
}