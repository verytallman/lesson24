package com.ex.api;

import java.util.Map;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiSuite extends BaseTest {

    @Test
    public void getUsersTest() {
        Map<String, Object> mapUsers = usersRequests
            .getUsersRequest("7a0c3cc7360784220359f6f0ab20a0d3e33101742a5fd5c7883ed0006cfece60",
                "/users", 200);
        Response response = (Response) mapUsers.get("response");
        assertThat(response.contentType()).as("").isEqualTo("application/json; charset=utf-8");
    }
}
