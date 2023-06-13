package com.example.demo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.response.AddressResponse;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public AddressResponse findAddressByEmployeeId(int employeeId)
	{
		Optional<Address> addressByEmployeeId = addressRepository.findAddressByEmployeeId(employeeId);
		AddressResponse addressResponse = mapper.map(addressByEmployeeId,  AddressResponse.class);
		return addressResponse;
	}
	public void saveAddress(Address address)
	{
		addressRepository.save(address);
	}
}
