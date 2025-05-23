package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { // wrapper for RestAssured

    // This will have common stuff

    //BASE_URI
    //Creating the Request
    //Handling the Response

    private static final String BASE_URL = "http://64.227.160.186:8080/"; //Anything that is constant will be final
                                                                        // and final always comes with static
    private RequestSpecification requestSpecification ;

    //In Java, static block will execute once so below code written in static block
    //If we write it in constructor, then in parallel testing it will execute every time
    static {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService (){  //Default Constructor to initialise data members(variables)
    requestSpecification = given().baseUri(BASE_URL); //return type of given is requestSpecification
    }

    protected Response postRequest(Object payload, String endpoint){
       return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);

    }

    protected Response putRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);

    }

    protected Response patchRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).patch(endpoint);

    }

    protected Response getRequest(String endpoint){
        return requestSpecification.get(endpoint);

    }

    protected void setAuthToken(String token){
        requestSpecification.header("Authorization", "Bearer "+token);
    }



}
