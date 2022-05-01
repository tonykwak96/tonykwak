package com.example.Project1.Controllers;

import com.example.Project1.Models.Reimbursement;
import com.example.Project1.Services.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController {

    @Autowired
    ReimbursementService reimbursementService;


    @PostMapping("/{name},{amount},{description}")
    public void createReimbursement(@PathVariable String name,@PathVariable double amount,@PathVariable String description){
        reimbursementService.createReimbursement(name,amount,description);
    }

    @GetMapping("/id/{id}")
    public List<Reimbursement> viewReimbursementById(@PathVariable int id){
        return reimbursementService.getAllReimbursementByName(id);
    }

    @GetMapping("/all")
    public List<Reimbursement> viewAllReimbursement(){
        return reimbursementService.getAllReimbursement();
    }

    @PutMapping("/approve/{id}")
    public void approveReimbursement(@PathVariable int id){
        reimbursementService.updateReimbursement("Approved",id);
    }

    @PutMapping("/deny/{id}")
    public void denyReimbursement(@PathVariable int id){
        reimbursementService.updateReimbursement("Denied",id);
    }

    @PutMapping("/reassign/{user_id},{id}")
    public void reassignReimbursement(@PathVariable int user_id, @PathVariable int id){
        reimbursementService.reassignUser(user_id,id);
    }

}
