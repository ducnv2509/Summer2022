package com.example.lab05.repository;

import com.example.lab05.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<User, Integer> {

}
