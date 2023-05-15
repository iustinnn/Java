package com.example.lab11.controller;

import com.example.lab11.model.User;
import com.example.lab11.service.service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class Controller {
    @Autowired
    private service userService;
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping(value = "/adduser")
    public void createProduct(@RequestBody User user) {
        userService.registerUser(user);
    }
    @GetMapping(value = "/welcome")
    public String getWelcome(){
        return "Hello world";
    }
}
