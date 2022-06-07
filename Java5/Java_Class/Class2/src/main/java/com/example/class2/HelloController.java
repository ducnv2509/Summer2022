package com.example.class2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("OK")
    @ResponseBody
    public String hello(){
       return "Nguyen Van Duc";
    }
}
