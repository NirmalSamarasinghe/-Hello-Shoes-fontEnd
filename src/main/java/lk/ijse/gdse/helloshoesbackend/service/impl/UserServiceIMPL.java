package lk.ijse.gdse.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.helloshoesbackend.repository.UserServiceDao;
import lk.ijse.gdse.helloshoesbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor

public class UserServiceIMPL implements UserService {
    private final UserServiceDao userDao;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userDao.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
