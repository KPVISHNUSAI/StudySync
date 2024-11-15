// analytics/UserAnalyticsDTO.java
package com.studysync.dto.analytics;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserAnalyticsDTO {
    private Long id;
    private LocalDate studyDate;
    private int totalMinutes;
    private int focusMinutes;
    private int breakMinutes;
    private int sessionsCompleted;
    private String dailyGoals;
    private String achievementMetrics;
}