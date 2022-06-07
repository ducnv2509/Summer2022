package com.example.lab34.service.Impl;

import com.example.lab34.entity.TypeAnswer;
import com.example.lab34.entity.TypeStatus;
import com.example.lab34.entity.User;
import com.example.lab34.repository.IUserRepository;
import com.example.lab34.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void saveUserToDb(MultipartFile file, String question, String option1, String option2, String option3, String option4, TypeAnswer typeAnswer, TypeStatus typeStatus, Date createDate) {
        User user = new User();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setQuestion(question);
        user.setOption1(option1);
        user.setOption2(option2);
        user.setOption3(option3);
        user.setOption4(option4);
        user.setAnswer(typeAnswer);
        user.setDateCreate(new Date());
        user.setTypeStatus(typeStatus);
        userRepository.save(user);
    }

    @Override
    public void updateUserToDb(MultipartFile file, Long id, String question, String option1, String option2, String option3, String option4, TypeAnswer typeAnswer, TypeStatus typeStatus, Date createDate) {
        User user = new User();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setId(id);
        user.setQuestion(question);
        user.setOption1(option1);
        user.setOption2(option2);
        user.setOption3(option3);
        user.setOption4(option4);
        user.setAnswer(typeAnswer);
        user.setDateCreate(new Date());
        user.setTypeStatus(typeStatus);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteSomeUser(Long[] ids) {
        this.userRepository.deleteUsersWithIds(Arrays.asList(ids));
    }

    @Override
    public Page<User> getPages(Pageable s) {
        return this.userRepository.findAll(s);
    }

    @Override
    public Page<User> findPaginated(int pageNo, int pageSize,  String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.userRepository.findAll(pageable);
    }



    @Override
    public Set<User> searchUsers(String type) {
        return new LinkedHashSet<>(this.userRepository.findAllByTypeRole(type));
    }



    @Override
    public void deleteUser(Long userId) {
        User user = new User();
        user.setId(userId);
        this.userRepository.delete(user);
    }


}
