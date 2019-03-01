package com.org.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.org.dao.CategoryDAO;
import com.org.bean.Category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryService {

	@Autowired(required=true)
	CategoryDAO categoryDAO;

	@Transactional
	public List<Category> getAllCategory() {
		
		return categoryDAO.getAllCategory();
	}

	@Transactional
	public Category getCategory(int id) {
		return categoryDAO.getCategory(id);
	}

	@Transactional
	public Category addCategory(Category category) {
		categoryDAO.addCategory(category);
		return category;
	}

	@Transactional
	public Category updateCategory(Category category) {
		categoryDAO.updateCategory(category);
		return category;
	}

	@Transactional
	public void deleteCategory(int id) {
		categoryDAO.deleteCategory(id);
	}
}
