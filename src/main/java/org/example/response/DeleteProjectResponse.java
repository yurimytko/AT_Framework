package org.example.response;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class DeleteProjectResponse {
    private int statusCode;
    private Response response;

    public DeleteProjectResponse(int statusCode, Response response) {
        this.statusCode = statusCode;
        this.response = response;
    }
}
