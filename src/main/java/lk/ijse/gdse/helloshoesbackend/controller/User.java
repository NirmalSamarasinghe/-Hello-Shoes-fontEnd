package lk.ijse.gdse.helloshoesbackend.controller;


import lk.ijse.gdse.helloshoesbackend.req_and_rest.response.SignUp;
import lk.ijse.gdse.helloshoesbackend.req_and_rest.response.SignIn;
import lk.ijse.gdse.helloshoesbackend.req_and_rest.secure.JWTAuthResponse;
import lk.ijse.gdse.helloshoesbackend.service.AuthenticationService;
import lk.ijse.gdse.helloshoesbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class User {
     private final UserService userService;

     private final AuthenticationService authenticationservice;

     @PostMapping("/signUp")
    public ResponseEntity<JWTAuthResponse> signUp(@RequestBody SignUp signUpReq) {
        return ResponseEntity.ok(authenticationservice.signup(signUpReq));

    }

    @PostMapping("/signIn")
    public ResponseEntity<JWTAuthResponse>singIn(@RequestBody SignIn singIn) {
         return ResponseEntity.ok(authenticationservice.signin(singIn));
    }
    @GetMapping("/refresh")
    public ResponseEntity<JWTAuthResponse>refresh(
            @RequestParam ("refreshToken")String refreshToken
    ){
         return ResponseEntity.ok(authenticationservice.refreshToken(refreshToken));
    }
}
