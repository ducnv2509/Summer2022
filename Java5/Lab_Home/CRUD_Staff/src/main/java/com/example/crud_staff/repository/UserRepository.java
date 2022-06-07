package com.example.crud_staff.repository;

import com.example.crud_staff.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
