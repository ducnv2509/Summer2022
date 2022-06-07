package com.example.springsample.controller;

import com.example.springsample.entity.Product;
import com.example.springsample.service.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String getAll(ModelMap model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "index";
    }


    public String add(Model map, Product product) {
        Product result = productService.add(product);
        if(result == null){
            return "error";
        }else{
            return "index-details";
        }
    }

}
