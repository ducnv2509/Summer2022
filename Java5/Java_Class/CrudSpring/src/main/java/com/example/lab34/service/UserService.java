package com.example.lab34.service;

import com.example.lab34.entity.TypeAnswer;
import com.example.lab34.entity.TypeStatus;
import com.example.lab34.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface UserService {

    public Set<User> searchUsers(String type);

    public void deleteUser(Long userId);

    public void saveUserToDb(MultipartFile file, String question, String option1, String option2, String option3, String option4, TypeAnswer typeAnswer, TypeStatus typeStatus, Date createDate);

    public void updateUserToDb(MultipartFile file, Long id, String question, String option1, String option2, String option3, String option4, TypeAnswer typeAnswer, TypeStatus typeStatus, Date createDate);

    public void deleteSomeUser(Long[] ids);

    public Page<User> getPages(Pageable s);

    Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
