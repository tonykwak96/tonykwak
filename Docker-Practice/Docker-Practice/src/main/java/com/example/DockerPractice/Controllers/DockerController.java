package com.example.DockerPractice.Controllers;

import com.example.DockerPractice.Models.User;
import com.example.DockerPractice.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DockerController {

    @Autowired
    UserRepo users;

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        users.save(user);

    }

    @DeleteMapping("/user/{name}")
    public void deletePlanet(){

    }

    @GetMapping("/user/{name}")
    public User viewUser(@PathVariable String name){
        return users.findByName(name);
    }

    @GetMapping("/users")
    public List<User> viewAllUsers(){
        return users.findAll();
    }

    @GetMapping("/hello")
    public String greeting(){
        return "Good morning";
    }


}
