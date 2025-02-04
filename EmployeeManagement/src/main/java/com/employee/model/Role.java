package com.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long role_id;
private String name;

public Role(String name) {
	super();
	this.name = name;
}
public long getId() {
	return role_id;
}
public void setId(long id) {
	this.role_id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
