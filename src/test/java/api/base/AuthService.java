package api.base;

import api.models.request.LoginRequest;
import api.models.request.SignupRequest;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService extends BaseService{

    private static final String BASE_PATH = "/api/auth/";

    public Response login(LoginRequest payload){
        return postRequest(payload, BASE_PATH + "login"); // postRequest method is from BaseService class
    }

    public Response signup(SignupRequest payload){
        return postRequest(payload, BASE_PATH + "signup"); // postRequest method is from BaseService class
    }

    public Response forgotPassword(String email){
        HashMap<String,String> payload = new HashMap<String, String>();
        payload.put("email", email);
        return postRequest(payload, BASE_PATH + "forgot-password"); // postRequest method is from BaseService class
    }



}
