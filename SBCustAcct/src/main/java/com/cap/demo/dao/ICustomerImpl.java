package com.cap.demo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.cap.demo.model.Account;
import com.cap.demo.model.Customer;

@Repository("customerDao")
public class ICustomerImpl implements ICustomer {

	private static AtomicInteger custid = new AtomicInteger(1);
	private static AtomicInteger acctid = new AtomicInteger(1);

	public List<Customer> customerDB = getDummyDB();

	private List<Customer> getDummyDB() {
		List<Customer> cust = new ArrayList<Customer>();
		List<Account> acct = new ArrayList<Account>();
		acct.add(new Account(acctid.getAndIncrement(), "Saving", LocalDate.of(2001, 02, 10), 10000, "Saving purpose"));
		acct.add(new Account(acctid.getAndIncrement(), "Over Draft", LocalDate.of(2001, 02, 10), 10000,
				"Over Draft scheme"));
		cust.add(new Customer(custid.getAndIncrement(), "Venu", "Venu12@hotmail.com", 123456, acct));
		
		List<Account> acct1 = new ArrayList<Account>();
		acct1.add(new Account(acctid.getAndIncrement(), "Saving", LocalDate.of(2001, 02, 10), 18500, "Saving purpose"));
		acct1.add(new Account(acctid.getAndIncrement(), "Over Draft", LocalDate.of(2001, 02, 10), 8700,
				"Over Draft scheme"));
		cust.add(new Customer(custid.getAndIncrement(), "Raja", "RajaRani@hotmail.com", 57784, acct1));


		return cust;
	}

	@Override
	public List<Customer> getAllCustomers() {

		return customerDB;
	}

	@Override
	public List<Customer> addCustomer(Customer cust) {
		customerDB.add(cust);

		System.out.println("Adding elements in CustomerDB\t" + customerDB);

		return customerDB;
	}

	@Override
	public List<Customer> deleteCustomer(int custId) {

		System.out.println("Delete use id\t" + custId);
		for (Customer i : customerDB) {
			if (custId == i.getCustomerId()) {
				customerDB.remove(custId);
			}

		}

		return customerDB;
	}

}
