package com.ex.api.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostMethods {
    public Response withToken(String token, String resource, int expSC, String body) {
        RestAssured.baseURI = "https://gorest.co.in/public/v1";
        return given()
            .auth().oauth2(token)
            .when()
            .body(body)
            .post(resource)
            .then()
            .assertThat()
            .statusCode(expSC)
            .extract()
            .response();
    }
}
