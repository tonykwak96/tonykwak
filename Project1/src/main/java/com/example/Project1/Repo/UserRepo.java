package com.example.Project1.Repo;

import com.example.Project1.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository <User, Integer> {

    User findByName(String name);

    Optional<User> findById(Integer id);

}
