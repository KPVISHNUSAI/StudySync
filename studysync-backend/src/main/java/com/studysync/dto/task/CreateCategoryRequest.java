// task/CreateCategoryRequest.java
package com.studysync.dto.task;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCategoryRequest {
    @NotBlank(message = "Category name is required")
    private String name;
    private String description;
    private String colorCode;
}