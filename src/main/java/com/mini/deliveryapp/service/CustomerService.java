package com.mini.deliveryapp.service;

import com.byteapp.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer removeCustomerById(Integer customerId);
	
	public Customer viewCustomer(Integer customerId);

}
