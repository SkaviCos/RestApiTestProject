package com.socks.tests;

import com.socks.api.payload.UserPayload;
import com.socks.api.service.UserApiService;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsersTest {

    private final UserApiService userApiService = new UserApiService();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://127.0.0.1/";
    }

    @Test
    public void testCanRegisterUser() {
        UserPayload user = new UserPayload()
                .username(RandomStringUtils.randomAlphabetic(8))
                .email(RandomStringUtils.randomAlphabetic(8) + "@mail.com")
                .password("1234567");

        userApiService.registerUser(user).then().log().all()
                .assertThat()
                .statusCode(200);

    }

    @Test
    public void testCanNotRegisterUser() {
        UserPayload user = new UserPayload()
                .username(RandomStringUtils.randomAlphabetic(8))
                .email(RandomStringUtils.randomAlphabetic(8) + "@mail.com")
                .password("1234567");

        userApiService.registerUser(user).then().log().all()
                .assertThat()
                .statusCode(200);

        userApiService.registerUser(user)
                .then().log().all()
                .assertThat()
                .statusCode(500);

    }
}
