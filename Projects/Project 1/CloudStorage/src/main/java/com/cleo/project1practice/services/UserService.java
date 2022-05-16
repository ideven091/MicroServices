package com.cleo.project1practice.services;

import com.cleo.project1practice.domain.User;
import com.cleo.project1practice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final HashService hashService;

    public UserService(UserRepository userRepository, HashService hashService) {
        this.userRepository = userRepository;
        this.hashService = hashService;
    }

    public User saveUser(User newUser){



        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(newUser.getPassword(), encodedSalt);
        newUser.setPassword(hashedPassword);
        newUser.setUsername(newUser.getUsername());
        newUser.setFirstName(newUser.getFirstName());
        newUser.setLastName(newUser.getLastName());
        newUser.setSalt(encodedSalt);


        return userRepository.save(newUser);
    }





    public User getUser(String userName){
        return userRepository.getByUsername(userName);
    }
}
