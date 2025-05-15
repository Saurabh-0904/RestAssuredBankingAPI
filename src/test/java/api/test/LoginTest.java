package api.test;

import api.base.AuthService;
import api.models.request.LoginRequest;
import api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

@Test(description = "Verify that Login API is working fine")
    public void loginTest(){

    LoginRequest loginRequest = new LoginRequest("saurabh1234","saurabh@1234");
    AuthService authService = new AuthService();
    Response response = authService.login(loginRequest);
    LoginResponse loginResponse = response.as(LoginResponse.class); //Class reference we need to pass

    System.out.println(response.asPrettyString());
    System.out.println(loginResponse.getEmail());
    System.out.println(loginResponse.getToken());
    System.out.println(loginResponse.getId());

    Assert.assertTrue(loginResponse.getToken() != null);
    Assert.assertEquals(loginResponse.getEmail(),"saurabh@gmail.com");

}
}
