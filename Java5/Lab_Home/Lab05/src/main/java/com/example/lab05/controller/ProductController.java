package com.example.lab05.controller;

import com.example.lab05.entity.Category;
import com.example.lab05.entity.Product;
import com.example.lab05.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductDAO productDAO;

    @RequestMapping("/product/sort")
    public String index(Model model, @RequestParam("field") Optional<String> field) {
        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));
        model.addAttribute("field", field.orElse("price").toUpperCase());
        Sort sort1 = Sort.by(Sort.Direction.DESC, field.orElse("id"));
        model.addAttribute("field", field.orElse("id").toUpperCase());
        Sort sort2 = Sort.by(Sort.Direction.DESC, field.orElse("available"));
        model.addAttribute("field", field.orElse("available").toUpperCase());
        List<Product> items = productDAO.findAll(sort);
        List<Product> items1 = productDAO.findAll(sort1);
        List<Product> items2 = productDAO.findAll(sort2);
        model.addAttribute("items", items);
        model.addAttribute("items", items1);
        model.addAttribute("items", items2);
        return "products/sort";
    }

    @RequestMapping("/product/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 4);
        Page<Product> page = productDAO.findAll(pageable);
        model.addAttribute("page", page);
        return "products/sort";
    }
//
//    @RequestMapping("product/create")
//    public String create(Product item){
//        productDAO.save(item);
//        return "redirect:/product/index";
//    }
//
////    @RequestMapping("category/update")
////    public String update(Product item){
////        productDAO.save(item);
////        return "redirect:/product/edit/" + item.getId();
////    }
//
//    @RequestMapping("product/delete/{id}")
//    public String delete(@PathVariable("id") Integer id){
//        productDAO.deleteById(id);
//        return "redirect:/product/index";
//    }
}
