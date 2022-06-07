package com.example.lab34.controller;

import com.example.lab34.entity.UserType;
import com.example.lab34.entity.Users;
import com.example.lab34.repository.IUsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

@Controller

public class AccountController {
    @Autowired
    IUsersRepository repository;

    @RequestMapping("/user/index")
    public String getALL(ModelMap modelMap, Users user, @RequestParam(value = "keyword", required = false) String keyword) {
        List<UserType> list = new ArrayList<UserType>(EnumSet.allOf(UserType.class));
        modelMap.addAttribute("item", user);
        modelMap.addAttribute("typeRole", list);
        if (keyword == null) {
            modelMap.addAttribute("users", repository.findAll());
        } else {
            modelMap.addAttribute("users", repository.findAll(keyword));
        }
        return "index";
    }

    @RequestMapping("/user/create")
    public String save(Users users) {
        users.setCreateDate(new Date());
        repository.save(users);
        return "redirect:/user/index";
    }

    @RequestMapping("/user/edit/{id}")
    public String edit(ModelMap model, @PathVariable("id") Integer id) {
        Users item = repository.findById(id).get();
        model.addAttribute("item", item);
        List<Users> items = repository.findAll();
        model.addAttribute("users", items);
        List<UserType> list = new ArrayList<UserType>(EnumSet.allOf(UserType.class));
        model.addAttribute("typeRole", list);
        return "index";
    }

    @RequestMapping("user/update")
    public String update(Users item) {
        item.setCreateDate(new Date());
        repository.save(item);
        return "redirect:/user/edit/" + item.getId();
    }

    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return "redirect:/user/index";
    }

}
