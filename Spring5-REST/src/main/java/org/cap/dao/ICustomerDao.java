package org.cap.dao;

import java.util.List;

import org.cap.model.Customer;

public interface ICustomerDao {
	
	public List<Customer> getAllCustomers();

	public List<Customer> createCustomer(Customer customer);

}
