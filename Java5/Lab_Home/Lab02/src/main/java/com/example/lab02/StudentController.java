package com.example.lab02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("students")
public class StudentController {
    @ModelAttribute("students")
    public List<Student> getStudent() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("SO1", "Duc"));
        list.add(new Student("SO2", "Minh"));
        return list;
    }

    @GetMapping("new")
    public String newForm() {
        return "students/new";
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(@RequestParam("id") String id, @RequestParam("name") String name, ModelMap modelMap) {
        System.out.println(id);
        System.out.println(name);
        modelMap.addAttribute("id", id);
        modelMap.addAttribute("name", name);
        return "students/viewDetail";
    }

    @PostMapping("update")
    public String update(Student student, ModelMap modelMap) {
        modelMap.addAttribute("id", student.getId());
        modelMap.addAttribute("name", student.getName());
        return "students/viewDetail";
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable String id, ModelMap mode) {
        Student student = new Student();
        student.setId(id);
        student.setName("Ducnv");
        mode.addAttribute("student", student);
        return "students/edit";
    }

    @RequestMapping("list")
    public String list() {
        return "students/list";
    }

    @RequestMapping("search")
    public String search() {
        return "students/search";
    }
}
