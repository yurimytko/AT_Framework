package org.example.request;

import lombok.Data;

@Data
public class UpdateProjectRequest {
    private final String URL = "http://localhost:8080/api/v3/projects/{projectId}";

    private String apiKey;

    private int projectId;
    private String name;

    public UpdateProjectRequest(String apiKey, int projectId, String name) {
        this.apiKey = apiKey;
        this.projectId = projectId;
        this.name = name;
    }

    public String getURL(){
        return URL.replace("{projectId}", String.valueOf(projectId));
    }

    public String toJson(){
        return "{" +
                "    \"name\": \"" + name + "\"" +
                "}";
    }
}
