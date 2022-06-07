package com.example.lab34.repository;

import com.example.lab34.entity.UserType;
import com.example.lab34.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsersRepository extends JpaRepository<Users, Integer> {
//    @Query("Select u from Users  u where  u.fullName like %?1%")
    @Query("Select u from Users  u where CONCAT(u.fullName, u.username) like %?1%")
    List<Users> findAll(String keyword);

    List<Users> findByUserType(UserType userType);

    List<Users> findByFullName(String fullName);

}
