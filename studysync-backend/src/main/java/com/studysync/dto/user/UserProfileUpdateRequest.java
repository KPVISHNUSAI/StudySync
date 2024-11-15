// user/UserProfileUpdateRequest.java
package com.studysync.dto.user;

import lombok.Data;

@Data
public class UserProfileUpdateRequest {
    private String fullName;
    private String bio;
    private String profileImageUrl;
}