package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepo;

@Service
public class ExcelService {
	@Autowired
	private EmployeeRepo employeeRepo;
	public List<Employee> getData() {
		 List<Employee> listOfEmp=null;
		 listOfEmp=employeeRepo.findAll();
		
		 return listOfEmp;
	}

}
