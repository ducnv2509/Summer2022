package com.example.lab34.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.example.lab34.model.Cart;
import com.example.lab34.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartService implements ICartService {

	private static final String ATT_CART_NAME = "myCart";
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public Cart getCart() {
		Cart cart = (Cart) request.getSession()
				.getAttribute(ATT_CART_NAME);
		if (cart == null) {
			cart = new Cart();
			cart.setCartDetails(new HashMap<Integer, Integer>());
			request.getSession()
				.setAttribute(ATT_CART_NAME, cart);
		}
		return cart;
	}

	@Override
	public void addToCart(int productId, int quantity) {
		Cart cart = getCart();
		
		int currentQuantity = 0;
		// Neu san pham chua co trong gio hang
		if (cart.getCartDetails().containsKey(productId)) {
			// lay so luong hien co ra
			currentQuantity = cart.getCartDetails().get(productId);
		}
		// cong don
		int updatedQuantity = currentQuantity + quantity;
		cart.getCartDetails().put(productId, updatedQuantity);
	}

	@Override
	public void changeProductQuantity(int productId, int quantity) {
		Cart cart = getCart();
		cart.getCartDetails().put(productId, quantity);
	}

	@Override
	public void removeProduct(int productId) {
		Cart cart = getCart();
		cart.getCartDetails().remove(productId);
	}

	@Override
	public void removeProducts() {
		request.getSession().removeAttribute(ATT_CART_NAME);
	}
}
