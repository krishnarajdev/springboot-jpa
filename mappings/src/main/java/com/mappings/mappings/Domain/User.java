package com.mappings.mappings.Domain;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true)
	private Integer id;

	@Size(max = 40)
	@Column(name = "first_name")
	@NotNull
	private String firstName;

	@Size(max = 40)
	@Column(name = "last_name")
	@NotNull
	private String lastName;

	@Column(name = "age")
	private Integer age;

	@NotNull
	@Column(name = "dob")
	private Date dob;

	@Column(name = "email")
	private String Email;

	@JsonManagedReference
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	public Address address;

	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Phone> phone;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_project", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false) }, 
	inverseJoinColumns = { @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = false, updatable = false) })
	public Set<Project> project;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User(String firstName, String lastName, Integer age, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dob = dob;
	}

	public User() {
		super();
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User {id:" + id + ", firstName:" + firstName + ", lastName:" + lastName + ", age:" + age + ", dob:"
				+ dob + ", Email:" + Email + ", address:" + address + "}";
	}

}
