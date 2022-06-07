package com.example.lab12;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/test")
public class helloController {
    @RequestMapping(value = "/ok/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String helloView(@PathVariable String id){
        return id;
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    @ResponseBody
    public String OKMom(@RequestParam String id){
        return "Name: " + id;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String about(){
        return "about";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    @ResponseBody
    public String getAtudent(){
        Student st = new Student();
        st.setId(1L);
        st.setName("ABV");
        return "hello, " + st.getId() + " - " +  st.getName();
    }

    @GetMapping(value = "/gppd")
    @ResponseBody
    public String ok1(){
        return "Get Ne";
    }

    @PostMapping(value = "/gppd")
    @ResponseBody
    public String ok2(){
        return "Post Ne";
    }

    @DeleteMapping(value = "/gppd")
    @ResponseBody
    public String ok3(){
        return "Delete Ne";
    }

    @PutMapping(value = "/gppd")
    @ResponseBody
    public String ok4(){
        return "PUT Ne";
    }

}
