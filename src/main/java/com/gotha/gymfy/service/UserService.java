package com.gotha.gymfy.service;

import com.gotha.gymfy.entity.User;
import com.gotha.gymfy.exception.GymfyBusinessException;
import com.gotha.gymfy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User store(User user) {

       User userByEmail = this.findUserByEmail(user.getEmail());

       if (userByEmail != null) {
           throw new GymfyBusinessException("User already exists");
       }

        return this.userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }
}
