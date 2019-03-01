package com.org.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.org.dao.CustomerDAO;
import com.org.dao.CustomerDAO;
import com.org.bean.Customer;
import com.org.bean.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service("customerService")
public class CustomerService {

	@Autowired(required=true)
	CustomerDAO customerDAO;

	@Transactional
	public List<Customer> getAllCustomer() {
		return customerDAO.getAllCustomer();
	}

	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Transactional
	public Customer addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
		return customer;
	}

	@Transactional
	public Customer updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
		return customer;
	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}
}
