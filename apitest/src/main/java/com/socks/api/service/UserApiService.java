package com.socks.api.service;

import com.socks.api.payload.UserPayload;
import io.restassured.response.Response;


public class UserApiService extends ApiService {
    public Response registerUser(UserPayload user) {

        return setup()
                .body(user)
                .when()
                .post("register");
    }
}
