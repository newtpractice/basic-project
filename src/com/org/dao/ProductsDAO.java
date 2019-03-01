package com.org.dao;

import java.util.List;

import com.org.bean.Category;
import com.org.bean.Products;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productsDAO")
public class ProductsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Products> getAllProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Products> productsList = session.createQuery("from Products").list();
		System.out.println("FULL PRODUCTS LIST"+ productsList);
		
		return productsList;
	}
	public Products getProducts(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Products products = (Products) session.get(Products.class, new Integer(id));
		return products;
	}
	
	public List<Products> getProductsByCategoryId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query productsList = session.createQuery("from Products where categoryid=:id");
		productsList.setParameter("id", id);
		
		List<Products> li;
		li=productsList.list();
		
		return li;
	}

	public Products addProducts(Products products) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(products);
		return products;
	}

	public void updateProducts(Products products) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(products);
	}

	public void deleteProducts(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Products p = (Products) session.load(Products.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
