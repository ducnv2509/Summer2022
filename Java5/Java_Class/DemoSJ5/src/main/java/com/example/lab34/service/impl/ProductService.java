package com.example.lab34.service.impl;

import com.example.lab34.model.Product;
import com.example.lab34.repository.IProductRepository;
import com.example.lab34.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;
	
	public Page<Product> getByPage(int pageNumber, int maxRecord) {
		Pageable pageable = PageRequest.of(pageNumber, maxRecord);
		Page<Product> page = productRepository.findAll(pageable);
		return page;
	}
}


