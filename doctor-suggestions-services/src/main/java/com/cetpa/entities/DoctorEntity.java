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
@Table(name = "doctor")
public class DoctorEntity 
{
	@Id
	@GeneratedValue(generator = "doc_seq")
	@SequenceGenerator(name = "doc_seq",initialValue = 100,allocationSize = 1)
	private int docid;
	@NotNull(message = "Name is required")
	@Size(min=3,message="Name length must be atleast three character")
	@Pattern(regexp="^[a-zA-Z' ']*$",message="name can have only alphabets and space")
	private String name;
	@NotNull(message = "City is required")
	@Pattern(regexp="^Noida|Delhi|Faridabad$",message="city can either Noida or Delhi or Faridabad")
	private String city;
	@NotNull(message = "Email is required")
	@Email(message="email is invalid")
	private String email;
	@NotNull(message = "Phone number is required")
	@Pattern(regexp="^[0-9]{10,}$",message="Phone number is not valid")
	private String phone;
	@NotNull(message = "Speciality is required")
	@Pattern(regexp="^Orthopedic|Gynecology|Dermatology|ENT$", message="speciality can either Orthopedic|Gynecology|Dermatology|ENT")
	private String speciality;
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
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
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
