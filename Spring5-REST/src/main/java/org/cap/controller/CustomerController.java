package org.cap.controller;

import java.util.List;

import org.cap.dao.ICustomerDao;
import org.cap.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust")
public class CustomerController {

	@Autowired
	private ICustomerDao customerDao;
	
	@PostMapping("/customers")
	public ResponseEntity<List<Customer>> createCustomer(
			@RequestBody Customer customer){
		List<Customer> customers= customerDao.createCustomer(customer);
		if(customers==null || customers.isEmpty()) {
			return new ResponseEntity("Sorry! Customer Details Not Avilable!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers, 
				HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers= customerDao.getAllCustomers();
		if(customers==null || customers.isEmpty()) {
			return new ResponseEntity("Sorry! Customer Details Not Avilable!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers, 
				HttpStatus.OK);
	}
	
}
