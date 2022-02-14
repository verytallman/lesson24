package com.ex.api.requests;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UsersRequests extends BaseRequests {
    public Map<String, Object> getUsersRequest(String token, String resource, int expectedStatusCode) {
        Response response = getMethods
            .withToken(token, resource, expectedStatusCode);
        return new HashMap<String, Object>() {
            {
                put("response", response);
                put("id", response.toString());
            }
        };
    }
}
