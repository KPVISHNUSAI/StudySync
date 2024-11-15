// session/UpdateSessionRequest.java
package com.studysync.dto.session;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UpdateSessionRequest {
    private String title;
    private String description;
    private LocalDateTime scheduledStart;
    private LocalDateTime scheduledEnd;
    private Integer maxParticipants;
    private boolean isPrivate;
    private String sessionSettings;
}