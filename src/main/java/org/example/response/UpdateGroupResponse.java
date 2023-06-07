package org.example.response;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class UpdateGroupResponse {
    private int statusCode;
    private Response response;

    public UpdateGroupResponse(int statusCode, Response response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    public int getGroupId(){
        return response.getBody().jsonPath().get("id");
    }

    public String getGroupName(){
        return response.getBody().jsonPath().get("name");
    }

}
