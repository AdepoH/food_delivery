package com.mini.deliveryapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byteapp.model.Customer;
import com.byteapp.repository.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	

	@Override
	public Customer addCustomer(Customer customer) throws ExceptionInInitializerError {
		Optional<Customer> opt = customerDAO.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			throw new ExceptionInInitializerError("Customer already exists..");
		}else {
			return customerDAO.save(customer);
		}
	}


	@Override
	public Customer updateCustomer(Customer customer) throws ExceptionInInitializerError {
		Optional<Customer> opt = customerDAO.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			return customerDAO.save(customer);
		}else {
			throw new ExceptionInInitializerError("No such customer exists..");
		}
	}


	@Override
	public Customer removeCustomerById(Integer customerId) throws ExceptionInInitializerError {
		Optional<Customer> opt = customerDAO.findById(customerId);
		if(opt.isPresent()) {
			Customer customer = opt.get();
			customerDAO.delete(customer);
			return customer;
		}else {
			throw new ExceptionInInitializerError("No Customer found with ID: "+customerId);
		}
	}


	@Override
	public Customer viewCustomer(Integer customerId) throws ExceptionInInitializerError {
		Optional<Customer> opt = customerDAO.findById(customerId);
		if(opt.isPresent()) {
			Customer customer = opt.get();
			return customer;
		}else {
			throw new ExceptionInInitializerError("No Customer found with ID: "+customerId);
		}
	}

}
