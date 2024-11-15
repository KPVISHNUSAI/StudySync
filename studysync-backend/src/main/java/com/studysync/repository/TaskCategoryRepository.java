// TaskCategoryRepository.java
package com.studysync.repository;

import com.studysync.entity.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {
    List<TaskCategory> findByUserId(Long userId);
    List<TaskCategory> findByIsDefaultTrue();
}