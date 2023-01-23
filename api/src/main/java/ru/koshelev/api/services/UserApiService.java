package ru.koshelev.api.services;


import ru.koshelev.api.assertions.AssertableResponse;
import ru.koshelev.api.payloads.UserPayloads;

public class UserApiService extends ApiService {
    public AssertableResponse registerUser(UserPayloads user) {
        return  new AssertableResponse(setUp()
                .body(user)
                .when()
                .post("/api/users"));
    }
    public AssertableResponse getUsers(){
        return new AssertableResponse(setUp()
                .when()
                .get("/api/users?page=2"));
    }
}
