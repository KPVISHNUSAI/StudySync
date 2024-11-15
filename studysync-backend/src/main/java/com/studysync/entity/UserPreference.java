package com.studysync.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_preferences")
@Data
public class UserPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "notification_enabled")
    private boolean notificationEnabled = true;

    @Column(name = "sound_enabled")
    private boolean soundEnabled = true;

    @Column(name = "study_preferences", columnDefinition = "jsonb")
    private String studyPreferences;

    @Column(name = "theme_settings", columnDefinition = "jsonb")
    private String themeSettings;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}