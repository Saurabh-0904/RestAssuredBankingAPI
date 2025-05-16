package api.test;

import api.base.AuthService;
import api.base.UserManagementService;
import api.models.request.ChangePasswordRequest;
import api.models.request.LoginRequest;
import api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest {

    @Test (description = "Verify Change Password api is working fine")

    public void changePasswordTest(){

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("saurabh1234", "saurabh@1234"));
        LoginResponse loginResponse = response.as(LoginResponse.class); // Using this you will get token and pass in below

        UserManagementService userManagementService = new UserManagementService();

        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest("saurabh@1234", "Saurabh@1234", "Saurabh@1234");

        response = userManagementService.changePassword(changePasswordRequest, loginResponse.getToken());

        Assert.assertEquals(response.statusCode(), 200);



    }
}
