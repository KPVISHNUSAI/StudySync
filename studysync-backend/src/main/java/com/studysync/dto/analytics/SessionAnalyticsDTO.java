// analytics/SessionAnalyticsDTO.java
package com.studysync.dto.analytics;

import lombok.Data;

@Data
public class SessionAnalyticsDTO {
    private Long id;
    private Long sessionId;
    private int participantCount;
    private int durationMinutes;
    private float productivityScore;
    private String interactionMetrics;
}