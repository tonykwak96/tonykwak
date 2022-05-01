package com.example.Project1.Controllers;


import com.example.Project1.Models.User;
import com.example.Project1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public void createUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping("/name/{name}")
    public User viewUserByName(@PathVariable String name){
        return userService.viewUserByName(name);
    }

    @GetMapping("/id/{id}")
    public Optional<User> viewUserById(@PathVariable int id){
        return userService.viewUserById(id);
    }

    @GetMapping("/all")
    public List<User> viewAllUsers(){
        return userService.viewAllUsers();
    }
}
