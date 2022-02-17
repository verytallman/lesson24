package com.ex.api.requests;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.hamcrest.Matcher;

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

    public Map<String, Object> postUsersRequest(String token, String resource, int expectedStatusCode, String body) {
        Response response = postMethods
                .postWithToken(token,resource,expectedStatusCode, body);
        return new HashMap<String, Object>() {
            {
                put("response", response);
                put("id", response.toString());
                put("body", response.body());
            }
        };
    }
}
