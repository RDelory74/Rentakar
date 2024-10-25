package com.RentaKar.rentakar.web.controller;

import com.RentaKar.rentakar.web.dao.UserDao;
import com.RentaKar.rentakar.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControler {

    private final UserDao userDao;

    public UserControler(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/Users")
    public List<User> listeUsers() {
        return userDao.findAll();
    }

    @GetMapping("/Users/{id}")
    public User afficherUnUser(@PathVariable int id) {
        return userDao.findById(id);
    }

    @PostMapping("/Users")
    public User saveUser(@RequestBody User user) {
        return userDao.save(user);
    }
    @PutMapping("/Users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User updatedUser = userDao.findById(id);

        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setUsername(user.getUsername());

        userDao.save(updatedUser);

        return userDao.findById(id);
    }
    @DeleteMapping("Users/{id}")
    public User deleteUser(@PathVariable int id) {
        return null;
    }
}
