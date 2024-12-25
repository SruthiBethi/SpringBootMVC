package com.tcs.mvc.service;

import java.io.OptionalDataException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.mvc.controller.entity.EmployeeEntity;
import com.tcs.mvc.empmodel.EmployeeModel;
import com.tcs.mvc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public void setEmployee(EmployeeModel employeeModel)
	{
		
		 double ta;
		ta=0.08*employeeModel.getSalary();
		 double da;
		 da=0.05*employeeModel.getSalary();
		 double hra;
		 hra=0.12*employeeModel.getSalary();
		 double pf;
		 pf=0.03*employeeModel.getSalary();
		 double esi;
		 esi=0.02*employeeModel.getSalary();
		 double total;
		 total=employeeModel.getSalary()+ta+da+hra+pf+esi;
		 
		 EmployeeEntity employeeEntity=new EmployeeEntity();
		 
		 employeeEntity.setEmpName(employeeModel.getEmpName());
		 employeeEntity.setSalary(employeeModel.getSalary());
		 employeeEntity.setDepartment(employeeModel.getDepartment());
		 employeeEntity.setRole(employeeModel.getRole());
		 employeeEntity.setTa(ta);
		 employeeEntity.setDa(da);
		 employeeEntity.setHra(hra);
		 employeeEntity.setPf(pf);
		 employeeEntity.setEsi(esi);
		 employeeEntity.setTotal(total);
		 
		 employeeRepository.save(employeeEntity);
	}
	
	public List <EmployeeEntity> getEmployeeDetails() {
		List <EmployeeEntity> employees=employeeRepository.findAll();
		return employees;
	}
	
	public EmployeeEntity searchByID(Long id) 
	{
		Optional <EmployeeEntity> optionalData=employeeRepository.findById(id);
		
		if(optionalData.isPresent())
		{
			EmployeeEntity employee= optionalData.get();
			return employee;
		}
		else {
			return null;
		}
	}

	public void deleteEmployeeById(Long id) {
	
		employeeRepository.deleteById(id);
		
	}
	
}
