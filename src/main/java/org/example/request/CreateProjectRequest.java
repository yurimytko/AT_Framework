package org.example.request;

import lombok.Data;

@Data
public class CreateProjectRequest {
    private final String URL = "http://localhost:8080/api/v3/projects";

    private String apiKey;

    private String name;

    public CreateProjectRequest(String apiKey, String name) {
        this.apiKey = apiKey;
        this.name = name;
    }

    public String toJson(){
        return "{" +
                "    \"name\": \"" + name + "\"" +
                "}";
    }
}
