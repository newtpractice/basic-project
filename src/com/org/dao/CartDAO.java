package com.org.dao;

import java.util.List;

import com.org.bean.Cart;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cartDAO")
public class CartDAO {

	@Autowired(required=true)
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Cart> getAllCart() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cart> cartList = session.createQuery("from Cart").list();
		return cartList;
	}

	public Cart getCart(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cart cart = (Cart) session.get(Cart.class, new Integer(id));
		return cart;
	}

	public Cart addCart(Cart cart) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cart);
		return cart;
	}

	public void updateCart(Cart cart) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cart);
	}

	public void deleteCart(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cart p = (Cart) session.load(Cart.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
