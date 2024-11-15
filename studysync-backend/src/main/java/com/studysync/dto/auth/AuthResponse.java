// auth/AuthResponse.java
package com.studysync.dto.auth;

import com.studysync.dto.user.UserDTO;
import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String refreshToken;
    private UserDTO user;
}
