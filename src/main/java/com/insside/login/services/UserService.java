package com.insside.login.services;

import java.util.ArrayList;
import java.util.Optional;

import com.insside.login.models.User;
import com.insside.login.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public ArrayList<User> gUsers(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public Optional <User> getUser(Long id){
        return userRepository.findById(id);
    }

    public User saveUser (User user){
        return userRepository.save(user);
    }

  
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
