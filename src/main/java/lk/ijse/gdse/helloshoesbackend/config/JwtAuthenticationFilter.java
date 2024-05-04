package lk.ijse.gdse.helloshoesbackend.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.helloshoesbackend.service.JWTService;
import lk.ijse.gdse.helloshoesbackend.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    private final UserService userService;
    private final JWTService jwtService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        final String user_email;
        final String jwt;
        final String authorization_header = request.getHeader("Authorization");

        if (StringUtils.isEmpty(authorization_header) || !authorization_header.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authorization_header.substring(7);
        user_email = jwtService.extractUserName(jwt);

        System.out.println(SecurityContextHolder.getContext().getAuthentication());

        if (StringUtils.isNotEmpty(user_email) && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userService.userDetailsService().loadUserByUsername(user_email);

            //Validation of Token Status
            if (jwtService.isTokenValid(jwt, userDetails)) {
                SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource());
                emptyContext.setAuthentication(authenticationToken);
                SecurityContextHolder.setContext(emptyContext);
            }
        }
        filterChain.doFilter(request,response);
    }


}
