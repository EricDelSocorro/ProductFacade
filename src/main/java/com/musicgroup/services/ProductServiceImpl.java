package com.musicgroup.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicgroup.model.Product;
import com.musicgroup.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private  ProductRepository productRepository;
	
	public Product getProduct(String code) {
		return this.productRepository.getProduct(code);
	}

	@Transactional(readOnly = true)
	public ArrayList<Product> getAllProducts() {
		return (ArrayList<Product>) this.productRepository.getAllProducts();
	}

	@Transactional
	public void save(Product product) {
		this.productRepository.save(product);
	}
}