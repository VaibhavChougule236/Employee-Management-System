package com.employee.model;

import jakarta.persistence.*;

@Entity
@Table(name="EmployeeInfo")
public class Employe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long Id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role = "EMPLOYEE";
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe(long id, String firstName, String lastName, String email,String password) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employe [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
