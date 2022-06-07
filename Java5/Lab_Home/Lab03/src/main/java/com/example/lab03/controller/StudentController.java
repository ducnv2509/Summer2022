package com.example.lab03.controller;

import com.example.lab03.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("students")
public class StudentController {
    @ModelAttribute("genders")
    public Map<Boolean, String> getGenders() {
        Map<Boolean, String> genders = new HashMap<>();
        genders.put(true, "Male");
        genders.put(false, "FeMale");
        return genders;
    }

    @ModelAttribute("hobbies")
    public Map<String, String> getHobbies() {
        Map<String, String> hobbies = new HashMap<>();
        hobbies.put("M", "Music");
        hobbies.put("S", "Sports");
        return hobbies;
    }

    @ModelAttribute("faculties")
    public List<String> getFaculties() {
        return Arrays.asList(
                "IT", "Web design", "BA", "PM"
        );
    }

    @Autowired
    ServletContext application;

    @GetMapping("new")
    public String newForm(ModelMap modelMap) {
        modelMap.addAttribute("student", new Student());

        return "students/addAndEdit";
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(@Validated @ModelAttribute("student") Student student, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "students/addAndEdit";
        }
//        if(!attach.isEmpty()){
//            String fileName = attach.getOriginalFilename();
//            File file = new File(application.getRealPath("/images/" + fileName));
//            attach.transferTo(file);
//        }
        if (!student.getImageFile().isEmpty()) {
            String part = application.getRealPath("/");
            System.out.println("PLLPP" + part);
            try {
                student.setImageUrl(student.getImageFile().getOriginalFilename());
                String filePath = part + "/images/" + student.getImageUrl();
                student.getImageFile().transferTo(Path.of(filePath));
                student.setImageFile(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "students/detail";
    }

}
