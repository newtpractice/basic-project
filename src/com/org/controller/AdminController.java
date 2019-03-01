package com.org.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;


import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.org.bean.Cart;
import com.org.bean.Category;
import com.org.bean.Customer;
import com.org.bean.Products;
import com.org.service.CartService;
import com.org.service.CategoryService;
import com.org.service.CustomerService;
import com.org.service.ProductsService;




@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger LOGGER = Logger.getLogger(AdminController.class);

	 
	
	@Autowired
	private CategoryService categoryService; 
	
	@Autowired
	private CartService cartService; 
	
	@Autowired
	private CustomerService customerService;
	

	@Autowired
	private ProductsService productsService;
	
	@RequestMapping(value="/start")
	public String userLogin(Model model) {
		
			return "UserLogin";
		}
	
	@RequestMapping(value="/startadmin")
	public String adminLogin(Model model) {
		
			return "adminlogin";
		}
	
	
	@RequestMapping(value="/ordercategories")
	public String orderCategories(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		List<Category> categoryList = new ArrayList();
		 categoryList = categoryService.getAllCategory();
		
			session.setAttribute("categories", categoryList);
			return "ordercategories";
		}
	@RequestMapping(value="/register")
	public String newUser(Model model) {
		
			return "RegForm";
		}
	@RequestMapping(value="/backtouserloginpage")
	public String backToUserLoginPage() {
		
			return "UserLogin";
		}
	
	@RequestMapping(value="/newcustomer",method = RequestMethod.GET)
	protected String newcustomer(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	
		int customerId=Integer.parseInt(request.getParameter("customerid"));
		String customerName=request.getParameter("customername");
		String loginId=request.getParameter("loginid");
		String password=request.getParameter("password");
		int phoneNumber =Integer.parseInt(request.getParameter("phonenumber"));
	
		Customer obj=new Customer();
		
		obj.setCustomerid(customerId);
		obj.setCustomername(customerName);
		obj.setLoginid(loginId);
		obj.setPassword(password);
		obj.setphonenumber(phoneNumber);
		
		customerService.addCustomer(obj);
		
		return "UserLogin";
		
		
	}
	
	
	@RequestMapping(value="/authenticate",method = RequestMethod.GET)
	protected String authenticate(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String userName1=request.getParameter("username");
		String password1=request.getParameter("password");

		if((password1.compareTo("newt@123")==0)&&(userName1.compareTo("admin")==0))
		{
			
			List<Category> categoryList = new ArrayList();
			 categoryList = categoryService.getAllCategory();
			
			//System.out.println("PRINTING FULL CATEGORY LIST"+categoryList);
				session.setAttribute("categories", categoryList);
			 
			return "categorypage";
		}
		else
		{
			return "error";
		}
    }
	
	@RequestMapping(value="/authenticatecustomer",method = RequestMethod.POST)
	protected String authenticateCustomer(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String loginId=request.getParameter("loginid");
		String password=request.getParameter("password");
        
		int customerId=1;
		List<Customer> customerList = new ArrayList();
		customerList=customerService.getAllCustomer();
		
		for(int j=0; j<customerList.size();j++)
		{
			if(customerList.get(j).getLoginid()==loginId)
			{
				customerId=customerList.get(j).getCustomerid();
			}
		}
		for(int i=0; i<customerList.size();i++)
		{
			String loginId1=customerList.get(i).getLoginid();
			String password1=customerList.get(i).getPassword();

		  if((password1.compareTo(password)==0)&&(loginId1.compareTo(loginId)==0))
		  {
			  session.setAttribute("customerid", customerId);
			  return "userfrontpage";
			  
		  }
		}
		
			return "error";
	}
	
	@RequestMapping(value="/editprofile")
	public String editProfile(HttpSession session ,HttpServletRequest request, HttpServletResponse response) {
		
		int customerId=Integer.parseInt(request.getParameter("id"));
		Customer obj=new Customer();
		obj=customerService.getCustomer(customerId);
		session.setAttribute("customer", obj);

		return "editprofile";
	}
	
	@RequestMapping(value="/userloginpage")
	public String userLoginPage(HttpSession session ,HttpServletRequest request, HttpServletResponse response) {
		
		
		return "UserLogin";
	}

	@RequestMapping(value="/saveprofile")
	public String saveProfile(HttpSession session ,HttpServletRequest request, HttpServletResponse response) {
		
		int customerId =Integer.parseInt(request.getParameter("customerid"));
		String customerName =request.getParameter("customername");
		String loginId =request.getParameter("loginid");
		String password =request.getParameter("password");
		int phoneNumber =Integer.parseInt(request.getParameter("phonenumber"));
		
		Customer obj=new Customer();
		obj.setCustomerid(customerId);
		obj.setCustomername(customerName);
		obj.setLoginid(loginId);
		obj.setPassword(password);
		obj.setphonenumber(phoneNumber);
		customerService.updateCustomer(obj);
		
		return "userfrontpage";
	}
	
	
	@RequestMapping(value="/addcategory")
	public String addCategory(Model model) {
		
			return "addcategory";
		}


	@RequestMapping(value="/backto")
	public String backTo(Model model) {
		
			return "userfrontpage";
		}
	
	
	@RequestMapping(value="/backtohomepage")
	public String backToHomePage(Model model) {
		
			return "userfrontpage";
		}
	
	
	@RequestMapping(value="/addproduct")
	public String addProduct(HttpSession session ,HttpServletRequest request, HttpServletResponse response) {
		
		int id =Integer.parseInt(request.getParameter("id"));
		session.setAttribute("id", id);
			return "addproduct";
		}
	
	@RequestMapping(value="/orderconfirmation")
	public String orderConfirmation(HttpSession session ,HttpServletRequest request, HttpServletResponse response) {
		
		int productId =Integer.parseInt(request.getParameter("id"));
		Cart cart=new Cart();
		cart=cartService.getCart(productId);
		session.setAttribute("products", cart);
			return "OrderConfirmation";
		}
	
	@RequestMapping(value="/mycart")
	public String mycart(HttpSession session ,HttpServletRequest request, HttpServletResponse response) {
		
		List<Cart> cartList = new ArrayList();
		 cartList = cartService.getAllCart();
		
		//System.out.println("PRINTING FULL CATEGORY LIST"+categoryList);
			session.setAttribute("products", cartList);
		
		
			return "MyCart";		
		}
	
	
	@RequestMapping(value="/newrecord", method = RequestMethod.GET)
	protected String addcategory(HttpSession session ,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoryName=request.getParameter("categoryname");
		int id =Integer.parseInt(request.getParameter("categoryid"));
		
		Category category = new Category(id, categoryName);
		
		categoryService.addCategory(category);
		
		List<Category> categoryList = new ArrayList();
		 categoryList = categoryService.getAllCategory();
		
		//System.out.println("PRINTING FULL CATEGORY LIST"+categoryList);
			session.setAttribute("categories", categoryList);
		
		
			return "categorypage";		
		}
	
	@RequestMapping(value="/newproduct", method = RequestMethod.GET)
	//protected String addproduct(HttpSession session , HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		public String addproduct(HttpSession session , HttpServletRequest request, HttpServletResponse response,@RequestParam("file")MultipartFile file,@RequestParam("id")Integer categoryId,@ModelAttribute("productattribute")Products item) throws IOException{	
		String productName=  request.getParameter("productname");
		//int categoryId =  Integer.parseInt(request.getParameter("categoryid"));
		int productPrice= Integer.parseInt(request.getParameter("productprice"));
		Products product = new Products();
		product.setProductname(productName);
		product.setProductprice(productPrice);
		product.setCategoryid(categoryId);
		productsService.addProducts(product);
		
		List<Products> productsList=new ArrayList();
		productsList= productsService.getProductsByCategoryId(categoryId);
		
		String categoryName=categoryService.getCategory(categoryId).getCategoryname();
		
		session.setAttribute("products", productsList);
		session.setAttribute("categoryname", categoryName);
		session.setAttribute("categoryid", categoryId);
		
		
			return "viewcategory";		
		}
	
	@RequestMapping(value="/viewcategory", method = RequestMethod.GET)
	protected String viewCategory(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =Integer.parseInt(request.getParameter("id"));
		String categoryName=categoryService.getCategory(id).getCategoryname();
		Category cat=new Category(id, categoryName);
		//System.out.println(categoryName);
		
		List<Products> productsList=new ArrayList();
		productsList= productsService.getProductsByCategoryId(id);
		
		//System.out.println("PRINTING PRODUCT LIST"+ productsList);
		
		session.setAttribute("products", productsList);
		session.setAttribute("categoryname", categoryName);
		session.setAttribute("categoryid", id);
		
		
			return "viewcategory";		
		}
	
	@RequestMapping(value="/orderproducts", method = RequestMethod.GET)
	protected String orderProducts(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =Integer.parseInt(request.getParameter("id"));
		String categoryName=categoryService.getCategory(id).getCategoryname();
		Category cat=new Category(id, categoryName);
		//System.out.println(categoryName);
		
		List<Products> productsList=new ArrayList();
		productsList= productsService.getProductsByCategoryId(id);
		
		//System.out.println("PRINTING PRODUCT LIST"+ productsList);
		
		session.setAttribute("products", productsList);
		session.setAttribute("categoryname", categoryName);
		session.setAttribute("categoryid", id);
		
		
			return "orderproducts";		
		}

	@RequestMapping(value="/ordersuccessfullyplaced", method = RequestMethod.GET)
	protected String orderPlaced(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId =Integer.parseInt(request.getParameter("productid"));
		int productPrice =Integer.parseInt(request.getParameter("productprice"));
		int quantity =Integer.parseInt(request.getParameter("quantity"));
		String productName =request.getParameter("productname");
		
		Cart obj=new Cart();
		obj.setProductid(productId);
		obj.setProductname(productName);
		obj.setProductprice(productPrice);
		obj.setQuantity(quantity);
		cartService.updateCart(obj);
		
		return "OrderSuccessfullyPlaced";
	
		
	}
	
	@RequestMapping(value="/addtocart", method = RequestMethod.GET)
	protected String myCart(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId =Integer.parseInt(request.getParameter("id"));
	    
		Products obj= new Products();
		obj=productsService.getProducts(productId);
		
		Cart cart=new Cart();
		cart.setProductid(obj.getProductid());
		cart.setProductname(obj.getProductname());
		cart.setProductprice(obj.getProductprice());
		cart.setQuantity(0);
		
		cartService.addCart(cart);
		
		
		int id = obj.getCategoryid();
		String categoryName=categoryService.getCategory(id).getCategoryname();
		Category cat=new Category(id, categoryName);
		//System.out.println(categoryName);
		
		List<Products> productsList=new ArrayList();
		productsList= productsService.getProductsByCategoryId(id);
		
		//System.out.println("PRINTING PRODUCT LIST"+ productsList);
		
		session.setAttribute("products", productsList);
		session.setAttribute("categoryname", categoryName);
		session.setAttribute("categoryid", id);
		
		
			return "orderproducts";				
	}
	
	
		
	
	
	@RequestMapping(value="/deletecategory")
	public String deleteCategory(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		int id =Integer.parseInt(request.getParameter("id"));
		
		categoryService.deleteCategory(id);
		
		List<Category> categoryList = new ArrayList();
		 categoryList = categoryService.getAllCategory();
		
		//System.out.println("PRINTING FULL CATEGORY LIST"+categoryList);
			session.setAttribute("categories", categoryList);
		
		
			return "categorypage";
	
	}
	
	@RequestMapping(value="/deleteproduct")
	public String deleteProduct(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		int id =Integer.parseInt(request.getParameter("id"));
		Products product=new Products();
		product=productsService.getProducts(id);
		System.out.println(product);
		
		productsService.deleteProducts(id);
		
		
		
		int categoryId = product.getCategoryid();
		String categoryName=categoryService.getCategory(categoryId).getCategoryname();
		//Category cat=new Category(id, categoryName);
		//System.out.println(categoryName);
		
		List<Products> productsList=new ArrayList();
		productsList= productsService.getProductsByCategoryId(categoryId);
		
		//System.out.println("PRINTING PRODUCT LIST"+ productsList);
		
		session.setAttribute("products", productsList);
		session.setAttribute("categoryname", categoryName);
		session.setAttribute("categoryid", categoryId);
		
			return "viewcategory";
	
	}
	

	@RequestMapping(value="/editproduct")
	public String editProduct(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
	
		int id =Integer.parseInt(request.getParameter("id"));
		Products p=new Products();
		p=productsService.getProducts(id);
		
		session.setAttribute("products", p);
		
		return "editproduct";
		
	}
	
	@RequestMapping(value="/updateproduct")
	public String updateProduct(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
	
		int categoryId =Integer.parseInt(request.getParameter("categoryid"));
		int productPrice =Integer.parseInt(request.getParameter("productprice"));
		String productName =request.getParameter("productname");
		
		Products obj=new Products();
		
		obj.setCategoryid(categoryId);
		obj.setProductname(productName);
		obj.setProductprice(productPrice);
		
		productsService.updateProducts(obj);
	
		List<Products> productsList=new ArrayList();
		productsList= productsService.getProductsByCategoryId(categoryId);
		String categoryName=categoryService.getCategory(categoryId).getCategoryname();
		
		//System.out.println("PRINTING PRODUCT LIST"+ productsList);
		
		session.setAttribute("products", productsList);
		session.setAttribute("categoryname", categoryName);
		session.setAttribute("categoryid", categoryId);
	
		return "viewcategory";
		
		
		
	}
		
	@RequestMapping(value="/loginpage")
	public String loginPage(Model model) {
		
			return "UserLogin";
		}	
		
	@RequestMapping(value="/logout")
	public String logout(Model model){
		return "logout";
	}
		
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error");
		return model;

	}
		
		
	/*
	@RequestMapping(value="/Logout")
	public String Logout(HttpSession session,HttpServletRequest request,Model model){
		HttpSession session2 = request.getSession(false);
		session2.removeAttribute("users");
		session2.removeAttribute("role");
		if(session2!=null){
			session2.invalidate();
		}
		return "logout";
	}
    
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getRecords(Model model) {
    	
    	List<User> users = userService.getAll();
    	
    	List<UserDTO> userDTO = new ArrayList<UserDTO>();
    	
    	for (User user: users) {
    		UserDTO dto = new UserDTO();
    		
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setPassword(user.getPassword());
			dto.setRole(roleService.getAll(user.getUserId()));
			
			userDTO.add(dto);
    	}
    	
    	model.addAttribute("users", userDTO);
		return "record";
	}
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	
    	model.addAttribute("userAttribute", new User());
    	
    	return "addUser";
	}
 
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("userAttribute") User user) {
		
    	userService.add(user);
		return "redirect:/record/list";
	}
    
 
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String getDelete(@RequestParam("id") Integer userId) {
    	
		userService.delete(userId);
		return "redirect:/record/list";
	}
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam("id") Integer userId, Model model) {
    	
    	User user1 = userService.get(userId);
    	model.addAttribute("userAttribute",user1);
    	
    	return "editUser";
	}
 
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@RequestParam("id") Integer userId, 
    						    @ModelAttribute("userAttribute") User user) {
		
		user.setUserId(userId);
		userService.edit(user);
		return "redirect:/record/list";
	}
*/
}
