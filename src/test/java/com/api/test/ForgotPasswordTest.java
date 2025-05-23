package com.api.test;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class ForgotPasswordTest {

@Test(description = "Verify that Forgot Password API is working fine")


    public void SignupTest(){

    AuthService authService = new AuthService();
    Response response = authService.forgotPassword("saurabh.bhalerao904@gmail.com");
    System.out.println(response.asPrettyString());

}
}
