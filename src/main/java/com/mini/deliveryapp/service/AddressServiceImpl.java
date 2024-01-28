package com.mini.deliveryapp.service;

import com.byteapp.model.Address;
import com.byteapp.model.Customer;
import com.byteapp.repository.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressDAO addressDAO;

    @Override
    public Address addAddress(Address address) throws ExceptionInInitializerError {
        Optional<Address> opt = addressDAO.findById(address.getAddressId());
        if(opt.isPresent()) {
            throw new ExceptionInInitializerError("Address already exists");
        }else {
            return addressDAO.save(address);
    }

        @Override
        public void deleteAddress(Integer addressId) {
            address.remove(a);
        }

    @Override
    public Address updateAddress(Address address) {
        return null;
    }

    @Override
    public Address removeAddressbyId(Integer addressId) {
        return null;
    }
}
