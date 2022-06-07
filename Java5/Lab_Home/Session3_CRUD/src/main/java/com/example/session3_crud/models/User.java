package com.example.session3_crud.models;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String fullName;
    private Integer age;
    private boolean gender;
}
