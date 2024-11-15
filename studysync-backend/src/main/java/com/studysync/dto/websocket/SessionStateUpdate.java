// websocket/SessionStateUpdate.java
package com.studysync.dto.websocket;

import lombok.Data;
import java.util.Map;

@Data
public class SessionStateUpdate {
    private Long sessionId;
    private String status;
    private Map<String, Object> stateChanges;
}