package com.example.lab11.service;

import com.example.lab11.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class service {
    List<User> listaUseri=new ArrayList();
    public void registerUser(User user) {
        listaUseri.add(user);
    }
    public List<User> getUsers() {
        return this.listaUseri;
    }

}
