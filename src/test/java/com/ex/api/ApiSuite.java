package com.ex.api;

import java.util.List;
import java.util.Map;

import com.ex.api.pojo.UsersPojo;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiSuite extends BaseTest {

    @Test
    public void getUsersTest() {
        Map<String, Object> mapUsers = usersRequests
                .getUsersRequest("5ccf86cb41dfb14017a732e52196fe71bf6adaf873586318b1f231a2bf1c265e",
                        "/users", 200);
        Response response = (Response) mapUsers.get("response");
        assertThat(response.contentType()).as("").isEqualTo("application/json; charset=utf-8");
    }


    @Test
    public void postUsersTest() {
        UsersPojo usersPojo = new UsersPojo(
                "John Wellmansly",
                "JohnWellmansly@test.com",
                "male",
                "active");
        Gson gson = new Gson();
        String json = gson.toJson(usersPojo);
        Map<String, Object> user1 = usersRequests.postUsersRequest(
                "5ccf86cb41dfb14017a732e52196fe71bf6adaf873586318b1f231a2bf1c265e",
                "/users",
                201,
                json);
        Response response = (Response) user1.get("response");
        JSONObject jsonObject = new JSONObject(response.asString());
        System.out.println("The new id is ="+jsonObject.get("id"));
        assertThat(jsonObject.get("name")).as("Name is invalid").isEqualTo("John Wellmansly");
        assertThat(jsonObject.get("email")).as("Email is invalid").isEqualTo("JohnWellmansly@test.com");

    }

}
