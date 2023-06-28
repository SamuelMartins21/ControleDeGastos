package com.example.controledegastos.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controledegastos.models.UserModel;
import com.example.controledegastos.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    } 
}
