package com.org.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class Cart implements Serializable{
	
	@Id
	@Column(name="productid")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	int productid;
	
	@Column(name="productname")
	String productname;	
	
	@Column(name="productprice")
	int productprice;	
	
	@Column(name="quantity")
    int quantity;

	public Cart() {
		super();
	}

	public Cart(int productid, String productname, int productprice, int quantity) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productprice = productprice;
		this.quantity = quantity;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	
	
	
	
}