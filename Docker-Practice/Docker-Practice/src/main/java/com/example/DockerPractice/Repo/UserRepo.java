package com.example.DockerPractice.Repo;

import com.example.DockerPractice.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Integer> {

    User findByName(String name);

}
