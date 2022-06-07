package com.example.lab34.controller;

import com.example.lab34.model.Product;
import com.example.lab34.service.ICartService;
import com.example.lab34.service.IProductService;
import com.example.lab34.utility.CommonConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private IProductService productService;
	@Autowired
	private ICartService cartService;
	
	@GetMapping
	public String getAll(Model model,
			@RequestParam(name = "pageNumber", defaultValue="0") int pageNumber) {
		Page<Product> productPage = productService
				.getByPage(pageNumber, CommonConst.PAGE_SIZE);
		model.addAttribute("page", productPage);
		return "shop/shopping";
	}
	
	@GetMapping("/cart/{productId}")
	public String addToCart(Model model, 
			@PathVariable int productId) {
		cartService.addToCart(productId, 1);
		model.addAttribute("cartDetails", 
				cartService.getCart().getCartDetails());
		return "shop/cart";
	}
}
