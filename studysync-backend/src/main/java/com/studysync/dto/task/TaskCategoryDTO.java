// task/TaskCategoryDTO.java
package com.studysync.dto.task;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskCategoryDTO {
    private Long id;
    private String name;
    private String description;
    private String colorCode;
    private boolean isDefault;
    private LocalDateTime createdAt;
}