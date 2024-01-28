package com.mini.deliveryapp.service;

import com.byteapp.model.Address;

public interface AddressService {
    public Address addAddress(Address address);
    public Address viewAddress(Integer addressId);
    public Address updateAddress(Address address);
    public Address removeAddressById(Integer addressId);
}
