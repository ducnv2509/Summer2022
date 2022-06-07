package com.example.lab34.controller;

import com.example.lab34.entity.TypeAnswer;
import com.example.lab34.entity.TypeRole;
import com.example.lab34.entity.TypeStatus;
import com.example.lab34.entity.User;
import com.example.lab34.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public String listAll(
            ModelMap modelMap
    ) {

        return findPaginated(1, modelMap, "id", "asc");
    }

    @RequestMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable("pageNo") int pageNo, ModelMap modelMap,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sorDir
    ) {
        modelMap.addAttribute("ACTION", "/quiz/save");
        modelMap.addAttribute("ACTION1", "/update");
        modelMap.addAttribute("DELETE", "/deleteAll");
        modelMap.addAttribute("SEARCH", "/search");
        modelMap.addAttribute("BASEURL", "/quiz");
        int pageSize = 5;
        Page<User> page = this.userService.findPaginated(pageNo, pageSize, sortField, sorDir);
        List<User> listUsers = page.getContent();
        modelMap.addAttribute("currentPage", pageNo);
        modelMap.addAttribute("totalPages", page.getTotalPages());
        modelMap.addAttribute("totalItems", page.getTotalElements());
        modelMap.addAttribute("sortField", sortField);
        modelMap.addAttribute("sortDir", sorDir);
        modelMap.addAttribute("reverseSortDir", sorDir.equals("asc") ? "desc" : "asc");
        modelMap.addAttribute("listUsers", listUsers);
        return "list_user";
    }


    @PostMapping("/save")
    public String save(@RequestParam("image") MultipartFile image,
                       @RequestParam("question") String question,
                       @RequestParam("option1") String option1,
                       @RequestParam("option2") String option2,
                       @RequestParam("option3") String option3,
                       @RequestParam("option4") String option4,
                       @RequestParam("answer") TypeAnswer answer,
                       @RequestParam("status") TypeStatus status
    ) {
        this.userService.saveUserToDb( image,  question,  option1,  option2,  option3,  option4,  answer,  status,  new Date());
        System.out.println("OKKOKO");
        return "redirect:/quiz/list";
    }

    @PostMapping("/update")
    public String update(@RequestParam("image") MultipartFile image,
                         @RequestParam("question") String question,
                         @RequestParam("option1") String option1,
                         @RequestParam("option2") String option2,
                         @RequestParam("option3") String option3,
                         @RequestParam("option4") String option4,
                         @RequestParam("answer") TypeAnswer answer,
                         @RequestParam("status") TypeStatus status,
                         @RequestParam("id") Long id
    ) {
        this.userService.updateUserToDb(image, id,  question,  option1,  option2,  option3,  option4,  answer,  status,  new Date());
        return "redirect:/quiz/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return "redirect:/quiz/list";
    }


    @RequestMapping("/deleteAll")
    public String deleteAll(@RequestParam("idAll") Long[] ids) {
        this.userService.deleteSomeUser(ids);
        return "redirect:/quiz/list";
    }

    @RequestMapping("/search")
    public String searchType(@RequestParam("keyword") String keyword, ModelMap modelMap) {
        Set<User> users = this.userService.searchUsers(keyword);
        System.out.println(users);
        List<TypeRole> listRole = new ArrayList<TypeRole>(EnumSet.allOf(TypeRole.class));
        modelMap.addAttribute("listUsers", users);
        modelMap.addAttribute("typeRole", listRole);
        return "list_user";
    }


}
