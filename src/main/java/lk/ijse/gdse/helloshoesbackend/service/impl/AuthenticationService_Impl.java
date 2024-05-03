package lk.ijse.gdse.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.helloshoesbackend.Enum.Role;
import lk.ijse.gdse.helloshoesbackend.dto.UserDTO;
import lk.ijse.gdse.helloshoesbackend.entity.UserEntity;
import lk.ijse.gdse.helloshoesbackend.repository.UserServiceDao;
import lk.ijse.gdse.helloshoesbackend.req_and_rest.response.SignIn;
import lk.ijse.gdse.helloshoesbackend.req_and_rest.response.SignUp;
import lk.ijse.gdse.helloshoesbackend.req_and_rest.secure.JWTAuthResponse;
import lk.ijse.gdse.helloshoesbackend.service.AuthenticationService;
import lk.ijse.gdse.helloshoesbackend.service.JWTService;
import lk.ijse.gdse.helloshoesbackend.util.ConversionData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationService_Impl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private  final UserServiceDao userDAO;
    private final ConversionData mapping;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTAuthResponse signUp(SignUp signUpReq) {
        UserDTO build = UserDTO.builder()
                .username_code(UUID.randomUUID().toString())
                .email(signUpReq.getEmail())
                .Password(passwordEncoder.encode(signUpReq.getPassword()))
                .role(Role.valueOf(String.valueOf(signUpReq.getRole())))
                .build();

        UserEntity user = userDAO.save(mapping.toUser(build));
        String generateToken = jwtService.generateToken(user);
        return JWTAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JWTAuthResponse singIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword())
    );
        UserEntity user = userDAO.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generateToken = jwtService.generateToken(user);
        return  JWTAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JWTAuthResponse refreshToken(String refreshToken) {
        var userEntity=userDAO
                .findByEmail(jwtService.extractUsername(refreshToken))
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
        return JWTAuthResponse.builder().token(jwtService.generateToken(userEntity)).build();
    }
}
