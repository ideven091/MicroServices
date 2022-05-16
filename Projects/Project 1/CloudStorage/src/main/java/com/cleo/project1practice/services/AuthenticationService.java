package com.cleo.project1practice.services;

import com.cleo.project1practice.domain.User;
import com.cleo.project1practice.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final HashService hashService;

    public AuthenticationService(UserRepository userRepository, HashService hashService) {
        this.userRepository = userRepository;
        this.hashService = hashService;
    }

    // FIXME: 21/03/22 //Grant user roles
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userRepository.getByUsername(userName);

        if(user!=null){
            String encodedSalt = user.getSalt();
            String hashedPassword = hashService.getHashedValue(password,encodedSalt);
            if(user.getPassword().equals(hashedPassword)){
                return new UsernamePasswordAuthenticationToken(userName,password, new ArrayList<>());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class
        );

    }
}
