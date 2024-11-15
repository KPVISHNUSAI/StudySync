package com.studysync.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "study_sessions")
@Data
public class StudySession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private User host;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private TaskCategory category;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String status;

    @Column(name = "scheduled_start")
    private LocalDateTime scheduledStart;

    @Column(name = "scheduled_end")
    private LocalDateTime scheduledEnd;

    @Column(name = "max_participants")
    private Integer maxParticipants = 10;

    @Column(name = "is_private")
    private boolean isPrivate = false;

    @Column(name = "session_code", unique = true)
    private String sessionCode;

    @Column(name = "session_settings", columnDefinition = "jsonb")
    private String sessionSettings;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @OneToMany(mappedBy = "session")
    private Set<SessionParticipant> participants;

    @OneToMany(mappedBy = "session")
    private Set<SessionChatMessage> chatMessages;
}