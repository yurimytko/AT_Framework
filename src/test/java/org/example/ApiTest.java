package org.example;

import org.example.request.*;
import org.example.response.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApiTest {
    private final OpenProjectApiBO openProjectApiBO = new OpenProjectApiBO();
    private final String apiKey = "ac51b0f1a1a02ee46290dfd79d44a254473d417bf189fb7a037820bbf558d9e1";
//    private final String apiKey = "YXBpa2V5OjQyY2ZjOTY4ZmY3ZjQzNGU3MDY5YTQyZmVlYTgyYjcyMjVjYjA1ZmU5ZjFiYTg5MTM0MDNkOTRhNTg2Mjg5YTc=";

    @DataProvider
    public Object[][] testFDataProvider() {
        return new Object[][]{
                {
                        "LOGAN", "r234u08u38u8f03482", "fLogan", "lLOgan", "logan@gmail.com"
                },
                {
                        "Rhino", "r234u0118u38u8f03482", "fRhino", "lRhino", "rhino@gmail.com"
                }
        };
    }

    @Test(dataProvider = "testFDataProvider")
    public void fTest(String login, String password, String firstName, String lastName, String email) {
        CreateUserRequest createUserRequest = new CreateUserRequest(
                apiKey,
                login,
                firstName,
                lastName,
                email,
                password
        );
        CreateUserResponse createUserResponse = openProjectApiBO.createUser(createUserRequest);
        createUserResponse.getResponse().body().prettyPrint();

        Assert.assertEquals(createUserResponse.getStatusCode(), 201);
        Assert.assertEquals(createUserResponse.getUserStatus(), "active");
        int userId = createUserResponse.getUserId();

        LockUserRequest lockUserRequest = new LockUserRequest(
                apiKey,
                userId
        );
        LockUserResponse lockUserResponse = openProjectApiBO.lockUser(lockUserRequest);
        Assert.assertEquals(lockUserResponse.getStatusCode(), 200);
        Assert.assertEquals(lockUserResponse.getUserStatus(), "locked");
        lockUserResponse.getResponse().body().prettyPrint();

        UnlockUserRequest unlockUserRequest = new UnlockUserRequest(
                apiKey,
                userId
        );
        UnlockUserResponse unlockUserResponse = openProjectApiBO.unlockUser(unlockUserRequest);
        Assert.assertEquals(unlockUserResponse.getStatusCode(), 200);
        Assert.assertEquals(unlockUserResponse.getUserStatus(), "active");
        unlockUserResponse.getResponse().body().prettyPrint();

    }


    @DataProvider
    public Object[][] testSDataProvider() {
        return new Object[][]{
                {
                        "FairmountGf", "CRM"
                },
                {
                        "Nan", "Nan"
                }
        };
    }
    @Test(dataProvider = "testSDataProvider")
    public void sTest(String projectCreationName, String projectUpdateName) {
        CreateProjectRequest createProjectRequest = new CreateProjectRequest(
                apiKey,
                projectCreationName
        );
        CreateProjectResponse createProjectResponse = openProjectApiBO.createProject(createProjectRequest);
        createProjectResponse.getResponse().body().prettyPrint();
        Assert.assertEquals(createProjectResponse.getStatusCode(), 201);
        Assert.assertEquals(createProjectResponse.getProjectName(), projectCreationName);

        int projectId = createProjectResponse.getProjectId();

        UpdateProjectRequest updateProjectRequest = new UpdateProjectRequest(
                apiKey,
                projectId,
                projectUpdateName
        );
        UpdateProjectResponse updateProjectResponse = openProjectApiBO.updateProject(updateProjectRequest);
        updateProjectResponse.getResponse().body().prettyPrint();
        Assert.assertEquals(updateProjectResponse.getStatusCode(), 200);
        Assert.assertEquals(updateProjectResponse.getProjectId(), projectId);
        Assert.assertEquals(updateProjectResponse.getProjectName(), projectUpdateName);


        DeleteProjectRequest deleteProjectRequest = new DeleteProjectRequest(
                apiKey,
                projectId
        );
        DeleteProjectResponse deleteProjectResponse = openProjectApiBO.deleteProject(deleteProjectRequest);
        deleteProjectResponse.getResponse().body().prettyPrint();
        Assert.assertEquals(deleteProjectResponse.getStatusCode(), 204);
    }

    @DataProvider
    public Object[][] testTDataProvider() {
        return new Object[][]{
                {
                        "Mashlick", "Shashlick"
                },
                {
                        "PsmNadfdmesddas1", "PsmfdadsdasfdName2"
                }
        };
    }

    @Test(dataProvider = "testTDataProvider")
    public void tTest(String groupCreationName, String groupUpdateName) {
        CreateGroupRequest createGroupRequest = new CreateGroupRequest(
                apiKey,
                groupCreationName
        );
        CreateGroupResponse createGroupResponse = openProjectApiBO.createGroup(createGroupRequest);
        createGroupResponse.getResponse().body().prettyPrint();
        Assert.assertEquals(createGroupResponse.getStatusCode(), 201);
        Assert.assertEquals(createGroupResponse.getGroupName(), groupCreationName);

        int groupId = createGroupResponse.getGroupId();

        UpdateGroupRequest updateGroupRequest = new UpdateGroupRequest(
                apiKey,
                groupId,
                groupUpdateName
        );
        UpdateGroupResponse updateGroupResponse = openProjectApiBO.updateGroup(updateGroupRequest);
        updateGroupResponse.getResponse().body().prettyPrint();
        Assert.assertEquals(updateGroupResponse.getStatusCode(), 200);
        Assert.assertEquals(updateGroupResponse.getGroupId(), groupId);
        Assert.assertEquals(updateGroupResponse.getGroupName(), groupUpdateName);


        DeleteGroupRequest deleteGroupRequest = new DeleteGroupRequest(
                apiKey,
                groupId
        );
        DeleteGroupResponse deleteGroupResponse = openProjectApiBO.deleteGroup(deleteGroupRequest);
        deleteGroupResponse.getResponse().body().prettyPrint();
        Assert.assertEquals(deleteGroupResponse.getStatusCode(), 202);
    }
}
