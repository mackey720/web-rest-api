package com.restapi.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerResource {
	
	@Autowired
	private ManagerDaoService service;
	
	//GET /api/managers
	//retrieveAllMangers
	@GetMapping("/api/managers")
	public List<Managers> retrieveAllManagers(){
		return service.findAll();
	}

}
