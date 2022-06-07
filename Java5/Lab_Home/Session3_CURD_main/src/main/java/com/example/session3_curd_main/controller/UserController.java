package com.example.session3_curd_main.controller;

import com.example.session3_curd_main.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String addOrEdit(ModelMap modelMap) {
        User u = new User();
        u.setFullName("NGuyen van Duc");
        modelMap.addAttribute("USER", u);
        modelMap.addAttribute("ACTION", "");
        return "register-user";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate() {
        return "register-user";
    }

    @RequestMapping("list")
    public String list() {
        return "view-user";
    }
}
