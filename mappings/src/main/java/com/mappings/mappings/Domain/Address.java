package com.mappings.mappings.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name ="address")
public class Address {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "door_no")
	private String doorNo;

	@Column(name = "street")
	private String street;

	@Column(name = "district")
	private String district;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address(Integer id, String doorNo, String street, String district, String state, String country) {
		super();
		this.id = id;
		this.doorNo = doorNo;
		this.street = street;
		this.district = district;
		this.state = state;
		this.country = country;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address {id:" + id + ", doorNo:" + doorNo + ", street:" + street + ", district:" + district + ", state:"
				+ state + ", country:" + country + "}";
	}
	
	

}
