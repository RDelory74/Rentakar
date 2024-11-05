package com.rentakar.web.controller;

import com.rentakar.model.Order;
import com.rentakar.service.UserService;
import com.rentakar.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControler {

    private final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> listeUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User afficherUnUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }
    @DeleteMapping("user/{id}")
    public User deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return null;
    }/// A refaire
    @GetMapping("/{id}/orders")
    public List<Order> orders(@PathVariable int id) {
        return userService.getOrdersByUserId(id);
    }


}