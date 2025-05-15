package api.test;

import api.base.AuthService;
import api.base.UserManagementService;
import api.models.request.LoginRequest;
import api.models.request.ProfilePatchRequest;
import api.models.response.LoginResponse;
import api.models.response.ProfilePatchResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PartialUpdateProfileTest {

    @Test (description = "Verify that Partial Update is working fine")

    public void partialUpdateProfileTest(){

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("saurabh1234", "saurabh@1234"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());

        System.out.println("---------------------------------------------------");

        UserManagementService userManagementService = new UserManagementService();

        ProfilePatchRequest profilePatchRequest = new ProfilePatchRequest("Saurabh", "Bhalerao", "saurabh.bhalerao904@gmail.com", "8308554578", "Thukaratwadi");

        response = userManagementService.partialUpdateProfile(profilePatchRequest, loginResponse.getToken());

        ProfilePatchResponse profilePatchResponse = response.as(ProfilePatchResponse.class);

        Assert.assertEquals(profilePatchResponse.getId(), 1099);
        Assert.assertEquals(profilePatchResponse.getFirstName(), "Saurabh");
        Assert.assertEquals(profilePatchResponse.getLastName(), "Bhalerao");
        Assert.assertEquals(profilePatchResponse.getEmail(), "saurabh.bhalerao904@gmail.com");
        Assert.assertEquals(profilePatchResponse.getMobileNumber(), "8308554578");
        Assert.assertEquals(profilePatchResponse.getAddress(), "Thukaratwadi");




    }
}
