package com.musicgroup.main;

import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.musicgroup.configuration.RootConfig;
import com.musicgroup.model.Product;
import com.musicgroup.services.ProductService;

public class MainApp {
	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		
		ProductService productService = context.getBean(ProductService.class);
		
		ArrayList<Product> products = productService.getAllProducts();
		
		for (Product product : products) {
			System.out.println("ID: " + product.getId());
			System.out.println("CODE: " + product.getCode());
			System.out.println("NAME: " + product.getName());
			System.out.println("DESCRIPTION: " + product.getDescription());
			System.out.println("DESCRIPTION: " + product.getPrice());
		}
		context.close();
	}
}
