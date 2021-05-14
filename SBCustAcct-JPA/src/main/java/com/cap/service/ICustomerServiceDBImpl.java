package com.cap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.dao.ICustomerDBDao;
import com.cap.model.Customer;

@Service("customerDBService")
public class ICustomerServiceDBImpl implements ICustomerServiceDB {

	@Autowired
	private ICustomerDBDao customerDBDao;

	@Override
	public List<Customer> getAllCustomers() {

		System.out.println("Get All Customer is called");

		return customerDBDao.findAll();

	}

	@Override
	public List<Customer> createCustomer(Customer cust) {
		System.out.println("Create Customer Called");
		customerDBDao.save(cust);
		return getAllCustomers(); // Need to put this one (List<Customer>) customerDBDao;
	}

	@Override
	public Customer findCustomer(Integer custId) {
		System.out.println("Find Customer Called");

		//return customerDBDao.getOne(custId);
		Optional<Customer> cust =  customerDBDao.findById(custId);
		if(cust.isPresent())
			return cust.get();
		else
			return new Customer();
		
	}

	@Override
	public List<Customer> deleteCustomer(Integer custId) {
		System.out.println("Delete Customer Called");
		customerDBDao.deleteById(custId);
		return getAllCustomers();
	}

	@Override
	public List<Customer> updateCustomer(Customer cust) {
		customerDBDao.save(cust);
		System.out.println("Update Customers");
		return getAllCustomers();
	}

}
