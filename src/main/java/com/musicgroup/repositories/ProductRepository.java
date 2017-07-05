package com.musicgroup.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.musicgroup.model.Product;


@Repository
public class ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Product getProduct(String code) {
		Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Product.class)
					.add(Restrictions.eq("code", code));
	
		Product product = (Product) criteria.uniqueResult();
	
		if (product != null) {
			return product;
		} else {
			return new Product();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Product");
		return query.list();
	}

	public void save(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}
}