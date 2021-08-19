package com.krzysztof.shop.shop.service;

import com.krzysztof.shop.shop.model.Address;
import com.krzysztof.shop.shop.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).get();
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

}
