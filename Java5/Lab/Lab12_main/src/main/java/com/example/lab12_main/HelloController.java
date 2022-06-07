package com.example.lab12_main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping(value = "/hello/message", method = RequestMethod.GET)
    @ResponseBody
    public String helloSpringMessage() {
        return "Hello Duc - PH14435";
    }

    //Q4
    @GetMapping(value = "/hello/view")
    public String helloSpringView() {
        return "hello";
    }

    // Q5
    @GetMapping(value = "/gppd")
    @ResponseBody
    public String requestPostmanGet() {
        return "Get Duc - PH14435";
    }

    @PostMapping(value = "/gppd")
    @ResponseBody
    public String requestPostmanPost() {
        return "Add Duc - PH14435";
    }

    @PutMapping(value = "/gppd")
    @ResponseBody
    public String requestPostmanPut() {
        return "Update Duc - PH14435";
    }

    @DeleteMapping(value = "/gppd")
    @ResponseBody
    public String requestPostmanDelete() {
        return "Delete Duc - PH14435";
    }

    //Q6

    @RequestMapping(value = "/path-variable/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String pathVariableOne(@PathVariable String id) {
        return "Tra ve " + id;
    }

    @RequestMapping(value = "/{id}/path-variable", method = RequestMethod.GET)
    @ResponseBody
    public String pathVariableTwo(@PathVariable String id) {
        return "Tra ve " + id;
    }

    @RequestMapping(value = "/request-param", method = RequestMethod.GET)
    @ResponseBody
    public String requestParam(@RequestParam String name) {
        if (name.trim().isEmpty()) {
            name = "Failed";
        }
        return "Name is: " + name;
    }

    @RequestMapping(value = "/hello/redirect", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView redirect() {
        return new ModelAndView("redirect:/about.html");
    }

    @RequestMapping(value = "/hello/forward", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView forward() {
        return new ModelAndView("forward:/about.html");
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent() {
        Student st = new Student();
        st.setId(14435L);
        st.setName("Nguyen Van Duc");
        return st;
    }


}
