package org.example.request;

import lombok.Data;

@Data
public class UpdateGroupRequest {
    private final String URL = "http://localhost:8080/api/v3/groups/{groupId}";

    private String apiKey;

    private int groupId;
    private String name;

    public UpdateGroupRequest(String apiKey, int groupId, String name) {
        this.apiKey = apiKey;
        this.groupId = groupId;
        this.name = name;
    }

    public String getURL(){
        return URL.replace("{groupId}", String.valueOf(groupId));
    }

    public String toJson(){
        return "{" +
                "    \"name\": \"" + name + "\"" +
                "}";
    }
}
