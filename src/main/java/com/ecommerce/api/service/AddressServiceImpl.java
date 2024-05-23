package com.ecommerce.api.service;

import com.ecommerce.api.entity.Address;
import com.ecommerce.api.exceptions.ApiException;
import com.ecommerce.api.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    @Override
    public Address findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElseThrow(() -> new ApiException("Address not found with id " + id , HttpStatus.NOT_FOUND));
    }
}
