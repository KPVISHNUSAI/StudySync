// analytics/AnalyticsPeriodRequest.java
package com.studysync.dto.analytics;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AnalyticsPeriodRequest {
    private LocalDate startDate;
    private LocalDate endDate;
}
