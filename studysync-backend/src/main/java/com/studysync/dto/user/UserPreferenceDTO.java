// user/UserPreferenceDTO.java
package com.studysync.dto.user;

import lombok.Data;

@Data
public class UserPreferenceDTO {
    private Long id;
    private boolean notificationEnabled;
    private boolean soundEnabled;
    private String studyPreferences;
    private String themeSettings;
}