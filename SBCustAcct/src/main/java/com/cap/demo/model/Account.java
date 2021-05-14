package com.cap.demo.model;

import java.time.LocalDate;

public class Account {
	
	private int accountId;
	private String accountType;
	private LocalDate openingDate = LocalDate.now();
	private int bal;
	private String desc;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", openingDate=" + openingDate
				+ ", bal=" + bal + ", desc=" + desc + "]";
	}
	public Account(int accountId, String accountType, LocalDate openingDate, int bal, String desc) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.openingDate = openingDate;
		this.bal = bal;
		this.desc = desc;
	}
	
  	

}
