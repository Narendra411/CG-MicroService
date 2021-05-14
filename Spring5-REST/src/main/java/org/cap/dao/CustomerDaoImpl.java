package org.cap.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.cap.model.Account;
import org.cap.model.Customer;
import org.springframework.stereotype.Repository;

@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao{
	private static AtomicInteger customerId=new AtomicInteger(1);
	private static AtomicInteger accountNo=new AtomicInteger(1000);
	private static List<Customer> customerDummyDb=dummyDB();
			
	private static List<Customer> dummyDB(){
		List<Customer> customers=new ArrayList<>();
			customers.add(new Customer(customerId.getAndIncrement(), "TOm", "32434324",
					new Account(accountNo.getAndIncrement(), "Savings", LocalDate.of(2000, 2, 12), 23000)));
		
			customers.add(new Customer(customerId.getAndIncrement(), "Thomson", "8676889",
					new Account(accountNo.getAndIncrement(), "Savings", LocalDate.of(2020, 3, 21), 3000)));
			
			customers.add(new Customer(customerId.getAndIncrement(), "Alwin", "6787878",
					new Account(accountNo.getAndIncrement(), "Current", LocalDate.of(2020, 2, 11), 5600)));
			
			customers.add(new Customer(customerId.getAndIncrement(), "Jack", "4535435",null));
		return customers;
	}
	
	
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDummyDb;
	}


	@Override
	public List<Customer> createCustomer(Customer customer) {
		customerDummyDb.add(customer);
		return customerDummyDb;
	}

}
