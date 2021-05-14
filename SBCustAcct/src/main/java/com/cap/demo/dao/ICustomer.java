package com.cap.demo.dao;

import java.util.List;

import com.cap.demo.model.Customer;

public interface ICustomer {
	
	public List<Customer> getAllCustomers();
	
	public List<Customer>  addCustomer(Customer cust);
	
	public List<Customer>  deleteCustomer(int custId);
	
	

}
