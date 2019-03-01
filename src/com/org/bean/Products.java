package com.org.bean;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="PRODUCTS")
public class Products implements Serializable{
	
	@Id
	@Column(name="productid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int productid;
	
	@Column(name="productname")
	String productname;	
	
	@Column(name="productprice")
	int productprice;	
	
    @Column(name="categoryid")
	int categoryid;	
	
    @Lob @Basic(fetch = FetchType.LAZY)	
	@Column(name="productimage",length=100000)
	private byte[] productimage;
    
	@ManyToOne(cascade = CascadeType.ALL)
	@ForeignKey(name="categoryid")
	@JoinColumn(name="categoryid", insertable= false, updatable= false, referencedColumnName = "categoryid",nullable=false)
	private Category category;
	
	public Products() {
		super();
	}

	public Products(int productid, String productname, int productprice, int categoryid, byte[] productimage) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productprice = productprice;
		this.categoryid = categoryid;
		this.productimage = productimage;
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

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public byte[] getProductimage() {
		return productimage;
	}

	public void setProductimage(byte[] productimage) {
		this.productimage = productimage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	
	
	
}