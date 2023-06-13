package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.response.AddressResponse;
import com.example.demo.response.EmployeeResponse;

import java.util.Optional;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void saveEmployee(Employee employee)
	{
		this.employeeRepository.save(employee);
	}
	
	public EmployeeResponse getEmployeeById(int id)
	{
		Optional<Employee> employee = employeeRepository.findById(id);
		EmployeeResponse employeeResponse = mapper.map(employee,  EmployeeResponse.class);
		AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8081/address-service/address/{id}", AddressResponse.class, id);
		employeeResponse.setAddressResponse(addressResponse);
		return employeeResponse;
		
	}
}
