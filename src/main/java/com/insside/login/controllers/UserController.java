package com.insside.login.controllers;

import java.util.*;


import com.insside.login.models.User;
import com.insside.login.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ArrayList<User> gUsers(){
        return userService.gUsers();
    }

    @GetMapping(path = "/users/{id}")
    public Optional <User> getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @RequestMapping("/users/current")
    public User getCurrentUser(Authentication authentication){
        return userService.findByUserName((authentication.getName()));
    }

    @PostMapping()
    public User saveUser(@RequestBody User user){
        return this.userService.saveUser(user);
    }
}
