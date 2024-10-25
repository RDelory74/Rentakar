package com.RentaKar.rentakar.web.controller;

import com.RentaKar.rentakar.web.dao.UserDao;
import com.RentaKar.rentakar.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControler {

    private final UserDao userDao;

    public UserControler(UserDao userDao) {
        this.userDao = userDao;
    }

@GetMapping("/Users")
    public List<User> listeUsers(){
    return userDao.findAll();
}

@GetMapping("/Users/{id}")
    public User afficherUnUser(@PathVariable int id){
   return userDao.findById(id);
}
}
