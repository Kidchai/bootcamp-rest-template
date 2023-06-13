package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.response.AddressResponse;
import com.example.demo.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId )
	{
		AddressResponse addressResponse = addressService.findAddressByEmployeeId(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}
	
	@PostMapping("/address")
	public ResponseEntity<Address> createAddress(@RequestBody Address address)
	{
		addressService.saveAddress(address);
		return ResponseEntity.status(HttpStatus.CREATED).body(address);
	}
}
