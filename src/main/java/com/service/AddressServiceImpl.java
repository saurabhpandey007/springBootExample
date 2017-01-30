package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public List<String> getDistinctStates() throws Exception {
		List<String> list =addressRepository.findDistinctState();
		return list;
	}

}
