package com.example.Project1.Controllers;


import com.example.Project1.Models.User;
import com.example.Project1.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepo users;

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        users.save(user);
    }

    @GetMapping("/user/name/{name}")
    public User viewUserByName(@PathVariable String name){
        return users.findByName(name);
    }

    @GetMapping("/user/id/{id}")
    public Optional<User> UserviewUserById(@PathVariable int id){
        return users.findById(id);
    }

    @GetMapping("/users")
    public List<User> viewAllUsers(){
        return users.findAll();
    }
}
