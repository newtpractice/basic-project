package com.org.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.org.dao.ProductsDAO;
import com.org.dao.ProductsDAO;
import com.org.bean.Products;
import com.org.bean.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service("productsService")
public class ProductsService {

	@Autowired
	ProductsDAO productsDAO;

	@Transactional
	public List<Products> getAllProducts() {
		return productsDAO.getAllProducts();
	}

	@Transactional
	public Products getProducts(int id) {
		return productsDAO.getProducts(id);
	}
	
	@Transactional
	public List<Products> getProductsByCategoryId(int id) {
		return productsDAO.getProductsByCategoryId(id);
	}

	@Transactional
	public Products addProducts(Products products) {
		productsDAO.addProducts(products);
		return products;
	}

	@Transactional
	public Products updateProducts(Products products) {
		productsDAO.updateProducts(products);
		return products;
	}

	@Transactional
	public void deleteProducts(int id) {
		productsDAO.deleteProducts(id);
	}
}
