package com.api.base;

import com.api.models.request.ChangePasswordRequest;
import com.api.models.request.ProfilePatchRequest;
import com.api.models.request.ProfileRequest;
import io.restassured.response.Response;

public class UserManagementService extends BaseService {

    private static final String BASE_PATH = "/com/api/users/";

    public Response getProfile (String token){
        setAuthToken(token);
        return getRequest(BASE_PATH +"profile");

    }

    public Response updateProfile (ProfileRequest payload , String token){
        setAuthToken(token);
        return putRequest(payload, BASE_PATH +"profile");

    }

    public Response partialUpdateProfile (ProfilePatchRequest payload , String token){
        setAuthToken(token);
        return patchRequest(payload, BASE_PATH +"profile");

    }

    public Response changePassword (ChangePasswordRequest payload , String token){
        setAuthToken(token);
        return putRequest(payload, BASE_PATH +"change-password");

    }

}
