package org.example.response;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class CreateUserResponse {
    private int statusCode;
    private Response response;

    public CreateUserResponse(int statusCode, Response response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    public int getUserId(){
        return response.getBody().jsonPath().get("id");
    }
    public String getUserStatus(){
        return response.getBody().jsonPath().get("status");
    }
}
