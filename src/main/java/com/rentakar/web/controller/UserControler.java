package com.rentakar.web.controller;

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

    @GetMapping("/Users")
    public List<User> listeUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/Users/{id}")
    public User afficherUnUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/Users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/Users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }
    @DeleteMapping("User/{id}")
    public User deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return null;
    }
    @GetMapping("/User/{id}/{order}"){

    }


}
