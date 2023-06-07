package org.example.request;

import lombok.Data;

@Data
public class DeleteProjectRequest {
    private final String URL = "http://localhost:8080/api/v3/projects/{projectId}";

    private String apiKey;

    private int projectId;

    public DeleteProjectRequest(String apiKey, int projectId) {
        this.apiKey = apiKey;
        this.projectId = projectId;
    }

    public String getURL(){
        return URL.replace("{projectId}", String.valueOf(projectId));
    }
}
