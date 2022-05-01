package com.example.Project1.Repo;

import com.example.Project1.Models.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReimbursementRepo extends JpaRepository<Reimbursement, Integer> {

    Optional<Reimbursement> findById(Integer id);

    List<Reimbursement> findAllById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value ="update reimbursements set status = ?1 where id = ?2", nativeQuery = true)
    void updateStatusById(String status, int id);
}
