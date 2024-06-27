package com.cetpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.DoctorEntity;
import com.cetpa.repositories.DoctorRepository;
import com.cetpa.services.DoctorService;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service
public class DoctorServiceImpl implements DoctorService
{
    @Autowired
    private DoctorRepository doctorRepository;

	@Override
	public void addDoctor(DoctorEntity doctor)
	{
		doctorRepository.save(doctor);
	}

	@Override
	public List<DoctorEntity> getList()
	{
		List<DoctorEntity> doctorList=doctorRepository.doctorList();
		return doctorList;
	}

	

}
