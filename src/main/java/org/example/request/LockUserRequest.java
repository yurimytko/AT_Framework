package org.example.request;

import lombok.Data;

@Data
public class LockUserRequest {
    private final String URL = "http://localhost:8080/api/v3/users/{userId}/lock";

    private String apiKey;

    private int userId;

    public LockUserRequest(String apiKey, int userId) {
        this.apiKey = apiKey;
        this.userId = userId;
    }

    public String getURL(){
        return URL.replace("{userId}", String.valueOf(userId));
    }
}
