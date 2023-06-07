package org.example.request;

import lombok.Data;

@Data
public class DeleteGroupRequest {
    private final String URL = "http://localhost:8080/api/v3/groups/{groupId}";

    private String apiKey;

    private int groupId;

    public DeleteGroupRequest(String apiKey, int projectId) {
        this.apiKey = apiKey;
        this.groupId = projectId;
    }

    public String getURL(){
        return URL.replace("{groupId}", String.valueOf(groupId));
    }
}
