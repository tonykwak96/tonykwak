package com.example.Project1.Services;

import com.example.Project1.Models.Reimbursement;
import com.example.Project1.Models.User;
import com.example.Project1.Repo.ReimbursementRepo;
import com.example.Project1.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReimbursementService {

    private ReimbursementRepo reimbursementRepo;
    private UserRepo userRepo;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();



    public ReimbursementService(ReimbursementRepo reimbursementRepo,UserRepo userRepo){
        super();
        this.reimbursementRepo = reimbursementRepo;
        this.userRepo = userRepo;
    }

    public boolean createReimbursement(String userName, double amount, String description){
        User user = userRepo.findByName(userName);
        System.out.println(user.toString());
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(amount);
        reimbursement.setDate(dtf.format(now));
        reimbursement.setStatus("Pending");
        reimbursement.setDescription(description);
        reimbursement.setUser(user);
        reimbursementRepo.save(reimbursement);
        return true;
    }

    public boolean updateReimbursement(String status, int id){
        reimbursementRepo.updateStatusById(status,id);
        return true;
    }

    public List<Reimbursement> getAllReimbursementByName(int id){
        return reimbursementRepo.findAllById(id);
    }

    public List<Reimbursement> getAllReimbursement(){
        return reimbursementRepo.findAll();
    }


}
