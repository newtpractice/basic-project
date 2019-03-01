package com.org.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.bean.Products;
import com.org.service.CartService;
import com.org.service.CategoryService;
import com.org.service.CustomerService;
import com.org.service.ProductsService;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import java.sql.Blob;


@Controller
@RequestMapping("/myImage")
public class ImageController {
	 
	
	@Autowired
	private CategoryService categoryService; 
	
	@Autowired
	private CartService cartService; 
	
	@Autowired
	private CustomerService customerService;
	

	@Autowired
	private ProductsService productsService;	
	
	private final int DEFAULT_BUFFER_SIZE = 10240;
	
	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	  public void showImage(@RequestParam("id") Integer productid, HttpServletResponse response,HttpServletRequest request) 
			  throws ServletException, IOException{
		
		Products item= productsService.getProducts(productid);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
				
		response.getOutputStream().write(item.getProductimage());

		response.getOutputStream().close();
		
	}
	

}
