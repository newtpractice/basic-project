/*package com.org.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.bean.Customer;

import com.org.service.EmployeeService;

@RestController
@RequestMapping("/Admin")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService ;

	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> getEmployee() {		
		List<Customer> listOfEmployees = employeeService.getAllEmployee();
		return listOfEmployees;
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer getEmployeeById(@PathVariable("id") int id) {		
		return employeeService.getEmployee(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Customer addEmployee(@RequestBody Customer customer) {
		System.out.println("add"+customer);
		return employeeService.addEmployee(customer);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public  Customer updateEmployee(@RequestBody Customer customer) {
		
		return employeeService.updateEmployee(customer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") int id) {
		
		employeeService.deleteEmployee(id);
	}
}
*/