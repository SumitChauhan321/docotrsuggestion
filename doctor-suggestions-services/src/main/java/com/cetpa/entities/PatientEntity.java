package com.cetpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "patient")
public class PatientEntity 
{
	@Id
	@GeneratedValue(generator = "pat_seq")
	@SequenceGenerator(name = "pat_seq",initialValue = 111,allocationSize = 1)
	private int patid;
	@NotNull(message = "Name is required")
	@Size(min=3,message="Name length must be atleast three character")
	@Pattern(regexp="^[a-zA-Z' ']*$",message="name can have only alphabets and space")
	private String name;
	@NotNull(message = "City is required")
	private String city;
	@NotNull(message = "Email is required")
	@Email(message="email is invalid")
	private String email;
	@NotNull(message = "Phone number is required")
	@Pattern(regexp="^[0-9]{10,}$",message="Phone number is not valid")
	private String phone;
	@NotNull(message = "Symptom is required")
	@Pattern(regexp="^Arthritis|Backpain|Tissue injuries|Dysmenorrhea|Skin infection|skin burn|Ear pain$",message="invalid symptom")
	private String symptom;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPatid() {
		return patid;
	}
	public void setPatid(int patid) {
		this.patid = patid;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	
	
}
