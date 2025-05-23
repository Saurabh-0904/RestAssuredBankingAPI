package com.api.test;

import com.api.base.AuthService;
import com.api.listeners.TestListener;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class SignupTest {

@Test(description = "Verify that Signup API is working fine")


    public void SignupTest(){

    //Builder design pattern
    //Calling static class Builder (As it is an inner class so we need to create an object of parent class)
    SignupRequest signupRequest =new SignupRequest.Builder()
            .firstName("Saurabh_")
            .lastName("_Bhalerao")
            .mobileNumber("9130504960")
            .username("srb1234")
            .password("srb@1234")
            .email("srbbhlro@gmail.com")
            .build();

    AuthService authService = new AuthService();
    Response response = authService.signup(signupRequest);
    Assert.assertEquals(response.asPrettyString() , "User registered successfully!");
    Assert.assertEquals(response.statusCode(),200);



}
}
