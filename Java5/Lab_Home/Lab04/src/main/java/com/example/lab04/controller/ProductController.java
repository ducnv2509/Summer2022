package com.example.lab04.controller;

import com.example.lab04.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("products", productService.findAll());
        return "products/list";
    }
}
