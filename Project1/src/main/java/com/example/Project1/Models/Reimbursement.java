package com.example.Project1.Models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Reimbursement")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Reimbursement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="date")
    private String date;

    @Column(name="amount")
    private double amount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", updatable = false, insertable = false)
    private User user;

}
