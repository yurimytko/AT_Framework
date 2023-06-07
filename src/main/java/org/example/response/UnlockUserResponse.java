package org.example.response;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class UnlockUserResponse {
    private int statusCode;
    private Response response;

    public UnlockUserResponse(int statusCode, Response response) {
        this.statusCode = statusCode;
        this.response = response;
    }
    public String getUserStatus(){
        return response.getBody().jsonPath().get("status");
    }
}
