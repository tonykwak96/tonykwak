package com.example.Project1.Models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Request")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


}
