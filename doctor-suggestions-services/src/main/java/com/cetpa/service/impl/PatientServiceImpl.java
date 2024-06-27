package com.cetpa.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.DoctorEntity;
import com.cetpa.entities.PatientEntity;
import com.cetpa.exceptions.PatientNotFound;
import com.cetpa.repositories.DoctorRepository;
import com.cetpa.repositories.PatientRepository;
import com.cetpa.services.PatientService;
import com.cetpa.utility.SymptomSpeciality;
@Service
public class PatientServiceImpl implements PatientService
{
	@Autowired
    private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public void addPatient(@Valid PatientEntity patient)
	{
	    patientRepository.save(patient);
	}

	public List<DoctorEntity> getList(int pid)
	{
		PatientEntity patient=patientRepository.findById(pid).orElseThrow(()-> new PatientNotFound("Patient with id" +pid+"does not exist"));
		String city=patient.getCity();
        if(!city.equals("Noida") && !city.equals("Delhi")&&!city.equals("Faridabad"))
        	throw new RuntimeException("we are still waiting to expand your location");
        String symptom=patient.getSymptom();
        String speciality=SymptomSpeciality.map.get(symptom);
        List<DoctorEntity> doctorList=doctorRepository.getDoctorList(city,speciality);
        if(doctorList.isEmpty())
        	throw new RuntimeException("There isn’t any doctor present at your location for your symptom");
		return doctorList;
	}

	@Override
	public List<PatientEntity> getList() 
	{
		List<PatientEntity> patientList=patientRepository.patientList();
		return patientList;
	}
}
