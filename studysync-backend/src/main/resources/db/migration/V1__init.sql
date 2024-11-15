-- Users Table
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    profile_image_url VARCHAR(255),
    bio TEXT,
    status VARCHAR(50) DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    is_active BOOLEAN DEFAULT true
);

-- User Preferences Table
CREATE TABLE user_preferences (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    notification_enabled BOOLEAN DEFAULT true,
    sound_enabled BOOLEAN DEFAULT true,
    study_preferences JSONB DEFAULT '{}',
    theme_settings JSONB DEFAULT '{}',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(user_id)
);

-- Task Categories Table
CREATE TABLE task_categories (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    name VARCHAR(100) NOT NULL,
    description TEXT,
    color_code VARCHAR(7),
    is_default BOOLEAN DEFAULT false,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Study Sessions Table
CREATE TABLE study_sessions (
    id BIGSERIAL PRIMARY KEY,
    host_id BIGINT REFERENCES users(id),
    category_id BIGINT REFERENCES task_categories(id),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) NOT NULL,
    scheduled_start TIMESTAMP,
    scheduled_end TIMESTAMP,
    max_participants INT DEFAULT 10,
    is_private BOOLEAN DEFAULT false,
    session_code VARCHAR(10) UNIQUE,
    session_settings JSONB DEFAULT '{}',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ended_at TIMESTAMP
);

-- Session Participants Table
CREATE TABLE session_participants (
    id BIGSERIAL PRIMARY KEY,
    session_id BIGINT REFERENCES study_sessions(id),
    user_id BIGINT REFERENCES users(id),
    role VARCHAR(50) DEFAULT 'PARTICIPANT',
    joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    left_at TIMESTAMP,
    is_camera_on BOOLEAN DEFAULT false,
    is_mic_on BOOLEAN DEFAULT false,
    UNIQUE(session_id, user_id)
);

-- Session Chat Messages Table
CREATE TABLE session_chat_messages (
    id BIGSERIAL PRIMARY KEY,
    session_id BIGINT REFERENCES study_sessions(id),
    user_id BIGINT REFERENCES users(id),
    message TEXT NOT NULL,
    message_type VARCHAR(50) DEFAULT 'TEXT',
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Buddy Connections Table
CREATE TABLE buddy_connections (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    buddy_id BIGINT REFERENCES users(id),
    status VARCHAR(50) DEFAULT 'PENDING',
    connected_at TIMESTAMP,
    is_favorite BOOLEAN DEFAULT false,
    collaboration_count INT DEFAULT 0,
    compatibility_score FLOAT,
    UNIQUE(user_id, buddy_id)
);

-- User Analytics Table
CREATE TABLE user_analytics (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    study_date DATE NOT NULL,
    total_minutes INT DEFAULT 0,
    focus_minutes INT DEFAULT 0,
    break_minutes INT DEFAULT 0,
    sessions_completed INT DEFAULT 0,
    daily_goals JSONB DEFAULT '{}',
    achievement_metrics JSONB DEFAULT '{}',
    recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(user_id, study_date)
);

-- Session Analytics Table
CREATE TABLE session_analytics (
    id BIGSERIAL PRIMARY KEY,
    session_id BIGINT REFERENCES study_sessions(id),
    participant_count INT DEFAULT 0,
    duration_minutes INT DEFAULT 0,
    productivity_score FLOAT,
    interaction_metrics JSONB DEFAULT '{}',
    recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes for better performance
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_study_sessions_host ON study_sessions(host_id);
CREATE INDEX idx_study_sessions_category ON study_sessions(category_id);
CREATE INDEX idx_session_participants_session ON session_participants(session_id);
CREATE INDEX idx_session_participants_user ON session_participants(user_id);
CREATE INDEX idx_buddy_connections_user ON buddy_connections(user_id);
CREATE INDEX idx_buddy_connections_buddy ON buddy_connections(buddy_id);
CREATE INDEX idx_user_analytics_user_date ON user_analytics(user_id, study_date);
CREATE INDEX idx_chat_messages_session ON session_chat_messages(session_id);
CREATE INDEX idx_task_categories_user ON task_categories(user_id);

-- Insert default task categories
INSERT INTO task_categories (name, description, color_code, is_default) VALUES
('Study', 'General study sessions', '#4A90E2', true),
('Exam Prep', 'Exam preparation sessions', '#E2574A', true),
('Group Project', 'Collaborative project work', '#50E3C2', true),
('Homework', 'Homework completion sessions', '#F5A623', true),
('Research', 'Research and reading sessions', '#9013FE', true);