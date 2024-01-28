package com.mini.deliveryapp.controller;

import com.byteapp.model.Address;
import com.byteapp.model.Customer;
import com.byteapp.service.AddressService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressServiceController {
    @Autowired
    AddressService addressService;


    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        Address newAddress = addressService.addAddress(address);
        return new ResponseEntity<Address>(newAddress, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){
        Address updateAddress = addressService.updateAddress(address);
        return new ResponseEntity<Address>(updateAddress, HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/remove/{addressId}")
    public ResponseEntity<Address> removeAddress(@PathVariable("addressId") Integer addressID){
        Address removeAddress = addressService.removeAddressById(addressID);
        return new ResponseEntity<Address>(removeAddress, HttpStatus.OK);
    }


    @GetMapping("/view/{addressId}")
    public ResponseEntity<Address> viewCustomer(@PathVariable("addressId") Integer addressId){
        Address address = addressService.viewAddress(addressId);
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

}
