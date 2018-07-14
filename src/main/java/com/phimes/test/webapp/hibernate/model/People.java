package com.phimes.test.webapp.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="People")
public class People {
	@Column (name="FIRSTNAME") 
	private String firstName;
	
	@Column (name="LASTNAME")
	private String lastName;
	
	@Column (name="AGE")
	 private Integer age;
	
	@Column (name="CITY")
	private String city;
	
	@Column (name="ID",insertable=false)
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
     generator = "retailerRaw_seq")
	@SequenceGenerator(name = "retailerRaw_seq", 
    sequenceName = "People_seq")
	private Integer id;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
