package lk.ijse.gdse.helloshoesbackend.service;

import lk.ijse.gdse.helloshoesbackend.req_and_rest.response.SignIn;
import lk.ijse.gdse.helloshoesbackend.req_and_rest.response.SignUp;
import lk.ijse.gdse.helloshoesbackend.req_and_rest.secure.JWTAuthResponse;

public interface AuthenticationService {

    JWTAuthResponse signup(SignUp request);

    JWTAuthResponse signin(SignIn request);

    JWTAuthResponse refreshToken(String refreshToken);
}
