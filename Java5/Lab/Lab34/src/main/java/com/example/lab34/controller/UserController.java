package com.example.lab34.controller;

import com.example.lab34.entity.UserType;
import com.example.lab34.entity.Users;
import com.example.lab34.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    IUsersRepository repository;

    @RequestMapping("/product")
    public List<Users> getALl() {
        return repository.findAll();
    }

    @PostMapping("/product")
    public Users add() {
        Users user = new Users();
        user.setUsername("admin");
        user.setPassword("nguyenvanduc");
        user.setFullName("Nguyen");
//        user.setImage(null);
        user.setUserType(UserType.valueOf("ADMIN"));
        return repository.save(user);
    }

    @GetMapping("/product/{id}")
    public Optional<Users> getById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PutMapping("/product/{id}")
    public Users update(@PathVariable Integer id) {
        Users user = new Users();
        user.setUsername("adminUpdate");
        user.setPassword("passwordUpdate");
        user.setFullName("Nguyen Van Duc");
        user.setId(id);
//        user.setCreateDate(new Date());
//        user.setImage(null);

        return repository.save(user);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/product")
    public List<Users> getByType(@RequestParam(name = "type", required = false) UserType type, @RequestParam(name = "name", required = false) String name) {
        if (type != null) {
            return repository.findByUserType(type);
        } else if (name != null) {
            return repository.findByFullName(name);
        }
        return repository.findAll();
    }
}
