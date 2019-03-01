package com.org.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.org.dao.CartDAO;
import com.org.bean.Cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService {

	@Autowired(required=true)
	CartDAO cartDAO;

	@Transactional
	public List<Cart> getAllCart() {
		
		return cartDAO.getAllCart();
	}

	@Transactional
	public Cart getCart(int id) {
		return cartDAO.getCart(id);
	}

	@Transactional
	public Cart addCart(Cart cart) {
	    cartDAO.addCart(cart);
		return cart;
	}

	@Transactional
	public Cart updateCart(Cart cart) {
		cartDAO.updateCart(cart);
		return cart;
	}

	@Transactional
	public void deleteCart(int id) {
		cartDAO.deleteCart(id);
	}
}
