package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Employe;

public interface EmployeeRepo extends JpaRepository<Employe,Long> {

}
