package com.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.employee.model.Employe;

public interface EmploeeServiceInterface {
List<Employe> getEmployees();
void saveEmployee(Employe employee);
Employe getEmployeeById(long id);
void deleteEmployeeById(long id);
Page<Employe> findPaginated(int pageNo,int pageSize,String sortField,String sortDirection);
}
