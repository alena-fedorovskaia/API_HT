package org.example.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class CommonService {
    private static final String BASE_URI = "https://petstore.swagger.io/v2/";

    private final Function<String, String> prepareUri = uri -> String.format("%s%s", BASE_URI, uri);

    protected RequestSpecification requestSpecification;

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        this.requestSpecification = RestAssured.given();
        setCommonParams();
    }

    protected void setCommonParams() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        requestSpecification.headers(headers);
    }

    protected Response getRequest(String uri) {
        return requestSpecification.expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().get(prepareUri.apply(uri));
    }

    protected Response postRequest(String uri, Object body) {
        return requestSpecification.body(body).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().post(prepareUri.apply(uri));
    }

    protected Response putRequest(String uri, Object body) {
        return requestSpecification.body(body).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().post(prepareUri.apply(uri));
    }
}
