package com.cap.demo.model;

import java.util.List;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String emailId;
	private int contactNum;
	private List<Account> Account;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getContactNum() {
		return contactNum;
	}
	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}
	public List<Account> getAccount() {
		return Account;
	}
	public void setAccount(List<Account> account) {
		Account = account;
	}
	public Customer(int customerId, String customerName, String emailId, int contactNum,
			List<com.cap.demo.model.Account> account) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.contactNum = contactNum;
		Account = account;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", contactNum=" + contactNum + ", Account=" + Account + "]";
	}
	
	

}
