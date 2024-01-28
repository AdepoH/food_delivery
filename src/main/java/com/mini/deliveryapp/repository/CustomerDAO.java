package com.mini.deliveryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteapp.model.Customer;


@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
