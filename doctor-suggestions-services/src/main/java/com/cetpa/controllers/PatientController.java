package com.cetpa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.DoctorEntity;
import com.cetpa.entities.PatientEntity;
import com.cetpa.services.PatientService;

@RestController
@RequestMapping("patient")
@CrossOrigin
public class PatientController 
{
   @Autowired
   private PatientService patientService;
   
   @PostMapping("add")
	public ResponseEntity<PatientEntity> addPatient(@Valid @RequestBody PatientEntity patient)
	{
		System.out.println("Controller called");
		patientService.addPatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
	}
   @GetMapping("doctor-list")
   public ResponseEntity<List<DoctorEntity>> getDoctorList(@RequestParam int pid)
   {
	   List<DoctorEntity> doctorList=patientService.getList(pid);
	   return ResponseEntity.ok(doctorList);
   }
   
   @GetMapping("patient-list")
	public ResponseEntity<List<PatientEntity>> patientList()
	{
		List<PatientEntity> patientList=patientService.getList();
		return ResponseEntity.status(HttpStatus.FOUND).body(patientList);
	}
   
}
