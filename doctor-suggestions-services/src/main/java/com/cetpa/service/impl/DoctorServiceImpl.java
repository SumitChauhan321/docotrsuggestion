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

	@Override
	public boolean sendEmail(String name, String emailID, String hospital, String speciality, String date) {
		
		boolean flag = false;
		String from = "sumitchauhan32164@gmail.com";
		// Variable for gmail
		String host = "smtp.gmail.com";
		String subject="Appointment Date";
		String message="Dear "+name+","+"Your appointment for "+speciality+" speciality has been fixed. And your date "+date;
				
        
		// get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES " + properties);

		// setting important information to properties object

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sumitchauhan32164@gmail.com", "lpxrdtfztkrthxos");
			}

		});

		session.setDebug(true);

		// Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);

		try {

			// from email
			m.setFrom(from);

			// adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(emailID));

			// adding subject to message
			m.setSubject(subject);

			// adding text to message
			m.setText(message);

			// send

			// Step 3 : send the message using Transport class
			Transport.send(m);

			System.out.println("Sent success...................");
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

}
