package com.cetpa.services;

import java.util.List;

import com.cetpa.entities.DoctorEntity;

public interface DoctorService {

	void addDoctor(DoctorEntity doctor);

	List<DoctorEntity> getList();

	boolean sendEmail(String name, String emailID, String hospital, String speciality, String date);

	

}
