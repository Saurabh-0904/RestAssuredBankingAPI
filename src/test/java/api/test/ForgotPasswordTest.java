package api.test;

import api.base.AuthService;
import api.models.request.SignupRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

@Test(description = "Verify that Forgot Password API is working fine")


    public void SignupTest(){

    AuthService authService = new AuthService();
    Response response = authService.forgotPassword("saurabh.bhalerao904@gmail.com");
    System.out.println(response.asPrettyString());

}
}
