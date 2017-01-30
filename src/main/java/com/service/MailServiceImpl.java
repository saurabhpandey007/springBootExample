package com.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.model.Employee;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	@Override
	public void sendRegistrationMail(Employee emp) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(emp.getEmail());
		mailMessage.setReplyTo(emp.getEmail());
		mailMessage.setFrom("aakash.vs13@gmail.com");
		mailMessage.setSubject("Registration Successfull.");
		mailMessage.setText("Registered Mail = "+emp.getEmail()+" /n "+" Employee Id = "+emp.getEmployeeId()+"\n"+"Employee Department = "+emp.getDepartment());
		mailMessage.setSentDate(new Date());
		javaMailSender.send(mailMessage);
	}

}
