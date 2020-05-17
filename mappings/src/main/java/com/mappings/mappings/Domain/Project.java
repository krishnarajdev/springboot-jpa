package com.mappings.mappings.Domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	
	@Id
	@GeneratedValue
	@Column(name ="id")
	private Integer id;
	
	@Column(name ="name")
	private String name;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<User> user = new HashSet<>();;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<User> getUser() {
		return user;
	}


	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	

}
