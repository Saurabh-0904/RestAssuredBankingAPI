package api.test;

import api.base.AuthService;
import api.base.UserManagementService;
import api.models.request.LoginRequest;
import api.models.response.GetProfileResponse;
import api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetProfileTest {

    /*
    To get the profile info flow, will be
    user should log in first -> navigate to a profile option
    And to do this before that we need to pass a token
    And token will be generating under AuthService
     */

    @Test
    public void getProfileTest(){
    AuthService authService = new AuthService();
    Response response = authService.login(new LoginRequest("saurabh1234","saurabh@1234"));
    LoginResponse loginResponse = response.as(LoginResponse.class);
    System.out.println(loginResponse.getToken());

    UserManagementService userManagementService = new UserManagementService();
    response = userManagementService.getProfile(loginResponse.getToken());
    GetProfileResponse getProfileResponse = response.as(GetProfileResponse.class);

    System.out.println(getProfileResponse.getUsername());
    }

}
