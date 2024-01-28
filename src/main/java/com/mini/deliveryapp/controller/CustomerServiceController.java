package com.mini.deliveryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byteapp.model.Customer;
import com.byteapp.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customer")
public class CustomerServiceController {
	
	@Autowired
	CustomerService customerService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		 Customer newCustomer = customerService.addCustomer(customer);
		 return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		 Customer updatedCustomer = customerService.updateCustomer(customer);
		 return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/remove/{customerId}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("customerId") Integer customerId){
		 Customer removedCustomer = customerService.removeCustomerById(customerId);
		 return new ResponseEntity<Customer>(removedCustomer, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") Integer customerId){
		 Customer customer = customerService.viewCustomer(customerId);
		 return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
