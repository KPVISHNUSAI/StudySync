// session/StudySessionDTO.java
package com.studysync.dto.session;

import com.studysync.dto.task.TaskCategoryDTO;
import com.studysync.dto.user.UserDTO;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class StudySessionDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime scheduledStart;
    private LocalDateTime scheduledEnd;
    private Integer maxParticipants;
    private boolean isPrivate;
    private String sessionCode;
    private UserDTO host;
    private TaskCategoryDTO category;
    private Set<SessionParticipantDTO> participants;
    private LocalDateTime createdAt;
    private LocalDateTime endedAt;
}