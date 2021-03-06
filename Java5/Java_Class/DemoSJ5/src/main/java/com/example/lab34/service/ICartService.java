package com.example.lab34.service;

import com.example.lab34.model.Cart;

public interface ICartService {

	Cart getCart();
	
	// them san pham vao gio hang
	void addToCart(int productId, int quantity);
	
	// thay doi so luong san pham trong gio
	void changeProductQuantity(int productId, int quantity);
	
	// bo 1 san pham trong gio
	void removeProduct(int productId);
	
	// bo tat ca san pham trong gio
	void removeProducts();
}
