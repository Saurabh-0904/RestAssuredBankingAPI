package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.UserProfileResponse;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserProfileTest {

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
    UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);

    System.out.println(userProfileResponse.getUsername());
        System.out.println(userProfileResponse.getFirstName());
        System.out.println(userProfileResponse.getLastName());
        System.out.println(userProfileResponse.getMobileNumber());
        System.out.println(userProfileResponse.getEmail());
    }

}
