// StudySessionRepository.java
package com.studysync.repository;

import com.studysync.entity.StudySession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {
    List<StudySession> findByHostId(Long hostId);
    
    @Query("SELECT s FROM StudySession s WHERE s.isPrivate = false AND s.status = 'ACTIVE'")
    List<StudySession> findPublicActiveSessions();
}