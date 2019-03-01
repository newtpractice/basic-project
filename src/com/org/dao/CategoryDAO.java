package com.org.dao;

import java.util.List;


import com.org.bean.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {

	@Autowired(required=true)
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Category> getAllCategory() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createQuery("from Category").list();
		System.out.println(categoryList);
		return categoryList;
	}

	public Category getCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category category = (Category) session.get(Category.class, new Integer(id));
		return category;
	}

	public Category addCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(category);
		return category;
	}

	public void updateCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(category);
	}

	public void deleteCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category p = (Category) session.load(Category.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
