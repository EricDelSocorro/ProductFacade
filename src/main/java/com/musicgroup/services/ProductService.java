package com.musicgroup.services;

import java.util.ArrayList;

import com.musicgroup.model.Product;

public interface ProductService {
	public Product getProduct(String code);
	public ArrayList<Product> getAllProducts();
	public void save(Product product);
}
