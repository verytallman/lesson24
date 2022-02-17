package com.ex.api.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.hamcrest.Matcher;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PostMethods {
    public Response postWithToken(String token, String resource, int expSC, String body) {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        return given()
            .contentType("application/json; charset=utf-8")
            .auth().oauth2(token)
            .body(body)
            .when()
            .post(resource)
            .then()
            .assertThat()
            .statusCode(expSC)
            .extract()
            .response();
    }
}
