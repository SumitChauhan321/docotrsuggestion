package com.cetpa.services;

import java.util.List;

import javax.validation.Valid;

import com.cetpa.entities.DoctorEntity;
import com.cetpa.entities.PatientEntity;

public interface PatientService 
{

	void addPatient(@Valid PatientEntity patient);

	List<DoctorEntity> getList(int pid);

	List<PatientEntity> getList();

}
