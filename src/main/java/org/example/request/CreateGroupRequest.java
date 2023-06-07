package org.example.request;

import lombok.Data;

@Data
public class CreateGroupRequest {
    private final String URL = "http://localhost:8080/api/v3/groups";

    private String apiKey;

    private String name;

    public CreateGroupRequest(String apiKey, String name) {
        this.apiKey = apiKey;
        this.name = name;
    }

    public String toJson(){
        return "{" +
                "    \"name\": \"" + name + "\"" +
                "}";
    }
}
