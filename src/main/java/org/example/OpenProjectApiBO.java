package org.example;

import io.restassured.response.Response;
import org.example.request.*;
import org.example.response.*;

import java.util.Base64;

import static io.restassured.RestAssured.given;

public class OpenProjectApiBO {
    private String getBasicToken(String apiKey){
        return Base64.getEncoder().encodeToString(("apikey:" + apiKey).getBytes());
    }

    public CreateUserResponse createUser(CreateUserRequest createUserRequest){
        Response response = given()
                .log().all()
                .header("Authorization", "Basic " + getBasicToken(createUserRequest.getApiKey()))
                .header("Content-Type", "application/json")
                .body(createUserRequest.toJson())
                .when()
                .post(createUserRequest.getURL());

        return new CreateUserResponse(response.statusCode(), response);
    }

    public LockUserResponse lockUser(LockUserRequest lockUserRequest){
        Response response = given()
                .log().all()
                .header("Authorization", "Basic " + getBasicToken(lockUserRequest.getApiKey()))
                .header("Content-Type", "application/json")
                .when()
                .post(lockUserRequest.getURL());

        return new LockUserResponse(response.statusCode(), response);
    }

    public UnlockUserResponse unlockUser(UnlockUserRequest unlockUserRequest){
        Response response = given()
                .log().all()
                .header("Authorization", "Basic " + getBasicToken(unlockUserRequest.getApiKey()))
                .header("Content-Type", "application/json")
                .when()
                .delete(unlockUserRequest.getURL());

        return new UnlockUserResponse(response.statusCode(), response);
    }

    public CreateProjectResponse createProject(CreateProjectRequest createProjectRequest){
        Response response = given()
                .log().all()
                .header("Authorization", "Basic " + getBasicToken(createProjectRequest.getApiKey()))
                .header("Content-Type", "application/json")
                .body(createProjectRequest.toJson())
                .when()
                .post(createProjectRequest.getURL());

        return new CreateProjectResponse(response.statusCode(), response);
    }

    public UpdateProjectResponse updateProject(UpdateProjectRequest updateProjectRequest){
        Response response = given()
                .log().all()
                .header("Authorization", "Basic " + getBasicToken(updateProjectRequest.getApiKey()))
                .header("Content-Type", "application/json")
                .body(updateProjectRequest.toJson())
                .when()
                .patch(updateProjectRequest.getURL());

        return new UpdateProjectResponse(response.statusCode(), response);
    }

    public DeleteProjectResponse deleteProject(DeleteProjectRequest deleteProjectRequest){
        Response response = given()
                .log().all()
                .header("Authorization", "Basic " + getBasicToken(deleteProjectRequest.getApiKey()))
                .header("Content-Type", "application/json")
                .when()
                .delete(deleteProjectRequest.getURL());

        return new DeleteProjectResponse(response.statusCode(), response);
    }

    public CreateGroupResponse createGroup(CreateGroupRequest createGroupRequest){
        Response response = given()
                .log().all()
                .header("Authorization", "Basic " + getBasicToken(createGroupRequest.getApiKey()))
                .header("Content-Type", "application/json")
                .body(createGroupRequest.toJson())
                .when()
                .post(createGroupRequest.getURL());

        return new CreateGroupResponse(response.statusCode(), response);
    }

    public UpdateGroupResponse updateGroup(UpdateGroupRequest updateGroupRequest){
        Response response = given()
                .log().all()
                .header("Authorization", "Basic " + getBasicToken(updateGroupRequest.getApiKey()))
                .header("Content-Type", "application/json")
                .body(updateGroupRequest.toJson())
                .when()
                .patch(updateGroupRequest.getURL());

        return new UpdateGroupResponse(response.statusCode(), response);
    }

    public DeleteGroupResponse deleteGroup(DeleteGroupRequest deleteGroupRequest){
        Response response = given()
                .log().all()
                .header("Authorization", "Basic " + getBasicToken(deleteGroupRequest.getApiKey()))
                .header("Content-Type", "application/json")
                .when()
                .delete(deleteGroupRequest.getURL());

        return new DeleteGroupResponse(response.statusCode(), response);
    }
}
