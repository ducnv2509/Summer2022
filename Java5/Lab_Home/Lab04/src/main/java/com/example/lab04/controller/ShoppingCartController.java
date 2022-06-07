package com.example.lab04.controller;

import com.example.lab04.CartItem;
import com.example.lab04.Product;
import com.example.lab04.service.ProductService;
import com.example.lab04.service.ShoppingCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    @Autowired
    ProductService productService;
    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("list")
    public String list(Model model) {
        Collection<CartItem> cartItems = shoppingCartService.getCarItems();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", shoppingCartService.getAmount());
        model.addAttribute("NoOfItems", shoppingCartService.getCount());
        return "shoppingCarts/list";
    }

    @GetMapping("add/{id}")
    public String add(@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        if (product != null) {
            CartItem item = new CartItem();
            BeanUtils.copyProperties(product, item);
            item.setQuantity(1);
            shoppingCartService.add(item);
        }
        return "redirect:/shoppingCart/list";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable Integer id) {
        shoppingCartService.remove(id);
        return "redirect:/shoppingCart/list";
    }

    @PostMapping("update")
    public String update(@RequestParam Integer id, @RequestParam Integer quantity) {
        shoppingCartService.update(id, quantity);
        return "redirect:/shoppingCart/list";
    }

    @GetMapping("clear")
    public String clear() {
        return "redirect:/shoppingCart/list";
    }

}
