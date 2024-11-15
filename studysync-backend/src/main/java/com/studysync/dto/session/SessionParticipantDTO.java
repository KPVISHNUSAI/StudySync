// session/SessionParticipantDTO.java
package com.studysync.dto.session;

import com.studysync.dto.user.UserDTO;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SessionParticipantDTO {
    private Long id;
    private UserDTO user;
    private String role;
    private LocalDateTime joinedAt;
    private LocalDateTime leftAt;
    private boolean isCameraOn;
    private boolean isMicOn;
}