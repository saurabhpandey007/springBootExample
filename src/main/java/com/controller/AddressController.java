package com.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@RequestMapping(value="/getstates")
	public List<String> createEmployee(HttpServletResponse response)
	{
		try {
			List<String> list = addressService.getDistinctStates();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			return null;
		}
		
	}
	
}
