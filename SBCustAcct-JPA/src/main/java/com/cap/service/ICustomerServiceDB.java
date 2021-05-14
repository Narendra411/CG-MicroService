package com.cap.service;

import java.util.List;

import com.cap.model.Customer;
public interface ICustomerServiceDB {

	public List<Customer> getAllCustomers();
	
	public List<Customer> createCustomer(Customer cust);
	
	public Customer findCustomer(Integer custId);
	
	public List<Customer> deleteCustomer(Integer custId);
	
	public List<Customer> updateCustomer(Customer cust);
	
}
