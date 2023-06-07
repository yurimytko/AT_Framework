package org.example.response;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class DeleteGroupResponse {
    private int statusCode;
    private Response response;

    public DeleteGroupResponse(int statusCode, Response response) {
        this.statusCode = statusCode;
        this.response = response;
    }
}
