// user/UserDTO.java
package com.studysync.dto.user;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String fullName;
    private String profileImageUrl;
    private String bio;
    private String status;
    private LocalDateTime lastLogin;
    private boolean isActive;
}
