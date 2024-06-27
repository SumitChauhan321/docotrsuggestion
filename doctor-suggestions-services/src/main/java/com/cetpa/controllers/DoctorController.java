package com.cetpa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.AppointmentEntity;
import com.cetpa.entities.DoctorEntity;
import com.cetpa.services.DoctorService;

@RestController
@RequestMapping("doctor")
@CrossOrigin
public class DoctorController 
{
	@Autowired private DoctorService doctorService;
	
	@PostMapping("add")
	public ResponseEntity<DoctorEntity> addDoctor(@Valid @RequestBody DoctorEntity doctor)
	{
		System.out.println("Controller called");
		doctorService.addDoctor(doctor);
		System.out.println(doctor.getName());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}
	@GetMapping("doctor-list")
	public ResponseEntity<List<DoctorEntity>> doctorList()
	{
		List<DoctorEntity> doctorList=doctorService.getList();
		return ResponseEntity.status(HttpStatus.FOUND).body(doctorList);
	}
	
//	 @GetMapping("appointment/{name}/{emailID}/{hospital}/{speciality}/{date}")
//	 public ResponseEntity sendEmail(@PathVariable String name,@PathVariable String emailID,@PathVariable String hospital,@PathVariable String speciality,@PathVariable String date)
//	 {
//		 boolean result=doctorService.sendEmail(name,emailID,hospital,speciality,date);
//			if(result)
//			{
//			return new ResponseEntity(HttpStatus.CREATED).ok("Email is send successfully");
//			}
//			else
//			{
//				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR).ok("Email not send");
//			}
//	 }
	
	
	
	
	@PostMapping("appointment")
	 public ResponseEntity sendEmail(@RequestBody AppointmentEntity appo)
	 {
		 boolean result=doctorService.sendEmail(appo.getName(),appo.getEmailID(),appo.getHospital(),appo.getSpeciality(),appo.getDate());
			if(result)
			{
			return new ResponseEntity(HttpStatus.CREATED).ok("Email is send successfully");
			}
			else
			{
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR).ok("Email not send");
			}
	 }
}
