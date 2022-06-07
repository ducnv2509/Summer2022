package com.example.lab34.repository;

import com.example.lab34.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query("delete from User u where u.id in (?1)")
    void deleteUsersWithIds(List<Long> ids);

    @Query(value = "select * from quizs where type_status = :keyword ", nativeQuery = true)
    List<User> findAllByTypeRole(String keyword);

}
