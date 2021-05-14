package com.cap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cap.model.Customer;
import com.cap.service.ICustomerServiceDB;

@RestController
@RequestMapping("/customer/api/v2")
public class CustomerDBRestController {

	@Autowired
	public ICustomerServiceDB customerDBService;

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerDBService.getAllCustomers();
		if (customers == null || customers.isEmpty())
			return new ResponseEntity("Sorry! No Customer Available!", HttpStatus.NOT_FOUND);

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);

	}

	@GetMapping("/customers/{custId}")
	public ResponseEntity<Customer> findCustomer(@PathVariable("custId") Integer custId) {
		Customer customers = customerDBService.findCustomer(custId);
		if (customers == null)
			return new ResponseEntity("Sorry! Customer Id not Available!", HttpStatus.NOT_FOUND);

		return new ResponseEntity<Customer>(customers, HttpStatus.OK);

	}

	@PostMapping("/customer")
	public ResponseEntity<List<Customer>> createCustomer(@RequestBody Customer customer) {
		List<Customer> customers = customerDBService.createCustomer(customer);
		if (customers == null || customers.isEmpty())
			return new ResponseEntity("Insertion Failed!!", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@PutMapping("/customer")
	public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer) {
		List<Customer> customers = customerDBService.updateCustomer(customer);
		if (customers == null || customers.isEmpty())
			return new ResponseEntity("Updation  Failed!!", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@DeleteMapping(value = "/customers/{custId}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("custId") Integer custId) {
		List<Customer> customers = customerDBService.deleteCustomer(custId);
		if (customers == null || customers.isEmpty())
			return new ResponseEntity("Deletion Failed!!", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

}
