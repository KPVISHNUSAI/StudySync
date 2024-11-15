package com.studysync.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "session_participants")
@Data
public class SessionParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private StudySession session;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String role;

    @Column(name = "joined_at")
    private LocalDateTime joinedAt;

    @Column(name = "left_at")
    private LocalDateTime leftAt;

    @Column(name = "is_camera_on")
    private boolean isCameraOn = false;

    @Column(name = "is_mic_on")
    private boolean isMicOn = false;
}