package com.example.lab34.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`quizs`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @Enumerated(EnumType.STRING)
    private TypeAnswer answer;
//    private String email;
//    private String phone;
    private String image;
    private Date dateCreate;
//    @Enumerated(EnumType.ORDINAL)
//    private TypeRole typeRole;
    @Enumerated(EnumType.STRING)
    private TypeStatus typeStatus;

}
