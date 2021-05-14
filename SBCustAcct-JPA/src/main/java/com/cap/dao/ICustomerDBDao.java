package com.cap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cap.model.Customer;

@Repository("customerDB")
@Transactional
public interface ICustomerDBDao extends JpaRepository<Customer, Integer> {

}
