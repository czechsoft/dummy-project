package org.example.demo.service;

import org.example.demo.entity.Address;
import org.example.demo.exception.ResourceNotFoundException;
import org.example.demo.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address addressDetails) {
        return addressRepository.findById(id)
                .map(address -> {
                    address.setPostalCode(addressDetails.getPostalCode());
                    address.setCity(addressDetails.getCity());
                    address.setStreet(addressDetails.getStreet());
                    address.setHouseNumber(addressDetails.getHouseNumber());
                    address.setFlatNumber(addressDetails.getFlatNumber());
                    return addressRepository.save(address);
                }).orElseThrow(() -> new ResourceNotFoundException("Address with ID " + id + " not found"));
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
