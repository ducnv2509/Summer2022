package com.example.lab34.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.example.lab34.model.Cart;
import org.springframework.stereotype.Service;


@Service
public class CartService {

	// Products in the cart, stored in Session.
	public Cart getCartInSession(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("myCart");
		if (cart == null) {
			cart = new Cart();
			cart.setCartDetails(new HashMap<Integer, Integer>());
			request.getSession().setAttribute("myCart", cart);
		}
		return cart;
	}

	public void removeCartInSession(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}
}
