package lk.ijse.gdse.helloshoesbackend.service;

import lk.ijse.gdse.helloshoesbackend.req_and_rest.response.SignIn;
import lk.ijse.gdse.helloshoesbackend.req_and_rest.response.SignUp;
import lk.ijse.gdse.helloshoesbackend.req_and_rest.secure.JWTAuthResponse;

public interface AuthenticationService {

    JWTAuthResponse signUp(SignUp signUpReq);

    JWTAuthResponse singIn(SignIn singIn);

    JWTAuthResponse refreshToken(String refreshToken);
}
