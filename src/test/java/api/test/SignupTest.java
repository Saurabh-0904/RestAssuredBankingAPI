package api.test;

import api.base.AuthService;
import api.models.request.LoginRequest;
import api.models.request.SignupRequest;
import api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupApiTest {

@Test(description = "Verify that Signup API is working fine")


    public void SignupTest(){

    //Builder design pattern
    //Calling static class Builder (As it is an inner class so we need to create an object of parent class)
    SignupRequest signupRequest =new SignupRequest.Builder()
            .firstName("Jaydev")
            .lastName("Bhalerao")
            .mobileNumber("9825784231")
            .username("jay1234")
            .password("jay@1234")
            .email("jay@yahoo.com")
            .build();

    AuthService authService = new AuthService();
    Response response = authService.signup(signupRequest);
    Assert.assertEquals(response.asPrettyString() , "User registered successfully!");
    Assert.assertEquals(response.statusCode(),200);



}
}
