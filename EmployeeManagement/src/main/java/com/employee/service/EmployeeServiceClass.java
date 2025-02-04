package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;


import com.employee.model.Employe;
import com.employee.repository.EmployeeRepo;

@Service
public class EmployeeServiceClass implements EmploeeServiceInterface {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employe> getEmployees() {
        return employeeRepo.findAll();
    }

	@Override
	public void saveEmployee(Employe employee) {
		employeeRepo.save(employee);
		
	}

	public Employe getEmployeeById(long id) {
		Optional<Employe> optional=employeeRepo.findById(id);
		Employe emp=null;
		if(optional.isPresent()) {
			emp=optional.get();	
			}else {
		throw new RuntimeException("Employee not found.........");
	}
		return emp;
	}
	@Override
	public void deleteEmployeeById(@PathVariable(value="id") long id) {
		this.employeeRepo.deleteById(id);
	}
	
	public Page<Employe> findPaginated(int pageNo, int pageSize,String sortField,String sortDir) {
	    Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortField).ascending():
	    	Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);
	    return this.employeeRepo.findAll(pageable);
	}

}
