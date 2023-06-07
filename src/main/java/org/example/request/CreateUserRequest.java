package org.example.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private final String URL = "http://localhost:8080/api/v3/users";

    private String apiKey;

    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public CreateUserRequest(String apiKey, String login, String firstName, String lastName, String email, String password) {
        this.apiKey = apiKey;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String toJson(){
        return "{" +
                "    \"login\": \"" + login + "\"," +
                "    \"firstName\": \"" + firstName + "\"," +
                "    \"lastName\": \"" + lastName + "\"," +
                "    \"email\": \"" + email + "\"," +
                "    \"password\": \"" + password + "\"" +
                "}";
    }
}
