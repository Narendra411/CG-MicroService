package com.cap.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cap.demo.dao.ICustomer;
import com.cap.demo.model.Customer;

@Repository
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private ICustomer customerDao;

	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomerDetails() {
		List<Customer> customer = customerDao.getAllCustomers();
		if (customer == null || customer.isEmpty()) {

			return new ResponseEntity("Customers are not available", HttpStatus.NOT_FOUND);
		}
		System.out.println("Customers are succesfully populated ");
		return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);

	}// GetMapping

	@PostMapping("/addCustomer")
	public ResponseEntity<List<Customer>> addCustomer(@RequestBody Customer cust) {
		List<Customer> customer = customerDao.addCustomer(cust);
		System.out.println("----PostMapping--");
		if (customer == null || customer.isEmpty()) {

			return new ResponseEntity("Customer is not added", HttpStatus.NOT_FOUND);

		}
		System.out.println("Customer is succefully added in dummyDB");
		return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);

	}

	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable int customerId) {
		List<Customer> customer = customerDao.deleteCustomer(customerId);
		System.out.println("----Delete--Mapping--");
		if (customer == null || customer.isEmpty()) {

			return new ResponseEntity("Customer is not deleted", HttpStatus.NOT_FOUND);

		}
		System.out.println("Customer is succefully deleted in dummyDB");
		return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);

	}
}