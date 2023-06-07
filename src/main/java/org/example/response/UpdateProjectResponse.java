package org.example.response;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class UpdateProjectResponse {
    private int statusCode;
    private Response response;

    public UpdateProjectResponse(int statusCode, Response response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    public int getProjectId(){
        return response.getBody().jsonPath().get("id");
    }

    public String getProjectName(){
        return response.getBody().jsonPath().get("name");
    }
}
