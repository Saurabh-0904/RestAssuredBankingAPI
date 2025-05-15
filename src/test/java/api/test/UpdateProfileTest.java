package api.test;


import api.base.AuthService;
import api.base.UserManagementService;
import api.models.request.LoginRequest;
import api.models.request.ProfileRequest;
import api.models.response.UserProfileResponse;
import api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    /*
    To update (put request), the profile flow will be
    user should log in first -> navigate to a profile option -> click on edit profile
     */

    @Test (description = "Verify that Update profile is working fine")

    public void updateProfileTest(){

        //Login and generate token
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("saurabh1234", "saurabh@1234"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());

        System.out.println("--------------------------------------------------------------------");

        UserManagementService userManagementService = new UserManagementService();
        /*response = userManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(),"saurabh1234");*/

        //System.out.println("--------------------------------------------------------------------");

        ProfileRequest profileRequest = new ProfileRequest();
        profileRequest.setFirstName("SAURABH__");
        profileRequest.setLastName("__BHALERAO");
        profileRequest.setMobileNumber("8889991112");
        profileRequest.setEmail("saurabh.bhalerao904@gmail.com");

        response = userManagementService.updateProfile(profileRequest, loginResponse.getToken());
        System.out.println(response.asPrettyString());

    }

}
