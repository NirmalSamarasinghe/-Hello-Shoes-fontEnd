package lk.ijse.gdse.helloshoesbackend.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String extractUsername(String token);
    String generateToken(UserDetails userDetails);

    boolean istokenValid(String token,UserDetails userDetails);
}
