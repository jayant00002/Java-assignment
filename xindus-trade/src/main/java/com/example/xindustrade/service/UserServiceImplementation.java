package com.example.xindustrade.service;


import java.util.Optional;
import java.util.UUID;

import com.example.xindustrade.Exception.UserException;
import com.example.xindustrade.Model.Users;
import com.example.xindustrade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users registerUser(Users users) throws UserException {
        Optional<Users> optUser = userRepository.findByEmail(users.getEmail());
        if (optUser.isPresent()) {
            throw new UserException("User exists with email " + users.getEmail());
        }
        users.setUserId(UUID.randomUUID().toString());
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return	userRepository.save(users);
    }

}
