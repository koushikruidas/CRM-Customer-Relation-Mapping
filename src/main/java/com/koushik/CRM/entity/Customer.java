package com.koushik.CRM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message="Cannot be Null")
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	@NotNull(message="required")
	private String firstName;
	
	@Column(name="last_name")
	@NotNull(message="required")
	private String lastName;
	
	@Column(name="email")
	@NotNull(message="required")
	private String email;

	public Customer() {
		
	}

	public Customer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
