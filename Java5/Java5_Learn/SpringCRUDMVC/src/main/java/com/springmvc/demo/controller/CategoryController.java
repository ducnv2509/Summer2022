package com.springmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "categories")
public class CategoryController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllCategories(ModelMap map) {
        return "category";
    }
}
