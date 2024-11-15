// buddy/BuddyConnectionDTO.java
package com.studysync.dto.buddy;

import com.studysync.dto.user.UserDTO;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BuddyConnectionDTO {
    private Long id;
    private UserDTO user;
    private UserDTO buddy;
    private String status;
    private LocalDateTime connectedAt;
    private boolean isFavorite;
    private int collaborationCount;
    private float compatibilityScore;
}