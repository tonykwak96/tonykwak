package com.example.Project1.Services;

import com.example.Project1.Models.User;
import com.example.Project1.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo){
        super();
        this.userRepo = userRepo;
    }

    public boolean saveUser(User user){
        userRepo.save(user);
        return true;
    }

    public User viewUserByName(String name){
        return userRepo.findByName(name);
    }

    public Optional<User> viewUserById(int id){
        return userRepo.findById(id);
    }

    public List<User> viewAllUsers(){
        return userRepo.findAll();
    }

}
