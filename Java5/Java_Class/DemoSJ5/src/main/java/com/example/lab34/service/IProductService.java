package com.example.lab34.service;

import com.example.lab34.model.Product;
import org.springframework.data.domain.Page;



public interface IProductService {

	Page<Product> getByPage(int pageNumber, int maxRecord);
}
