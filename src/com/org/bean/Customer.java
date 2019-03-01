package com.org.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable{
	
	@Id
	@Column(name="customerid")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	int customerid;
	
	@Column(name="customername")
	String customername;	
	
	@Column(name="loginid")
	String loginid;	
	
	@Column(name="password")
	String password;	
	
	@Column(name="phonenumber")
	int phonenumber;
	
	
	public Customer() {
		super();
	}


	public Customer(int customerid, String customername, String loginid, String password, int phonenumber) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.loginid = loginid;
		this.password = password;
		this.phonenumber = phonenumber;
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public String getCustomername() {
		return customername;
	}


	public void setCustomername(String customername) {
		this.customername = customername;
	}


	public String getLoginid() {
		return loginid;
	}


	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getphonenumber() {
		return phonenumber;
	}


	public void setphonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

/*
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", loginid=" + loginid
				+ ", password=" + password + ", phonenumber=" + phonenumber + "]";
	}
*/
	
	
	
}
