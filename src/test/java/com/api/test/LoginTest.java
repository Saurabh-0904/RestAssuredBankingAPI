package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class LoginTest {

    @Test(description = "Verify that Login API is working fine")
    public void loginTest(){

        LoginRequest loginRequest = new LoginRequest("saurabh1234","Saurabh@1234");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class); //Class reference we need to pass

        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getEmail());
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getId());

        Assert.assertTrue(loginResponse.getToken() != null);
        Assert.assertEquals(loginResponse.getEmail(),"saurabh.bhalerao904@gmail.com");

    }
}
