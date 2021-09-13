package com.supervisors.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class SupervisorsController {
	
	//GET
	//URI
	//method - Supervisors
	@GetMapping(path="/api/supervisors" )
	public String supervisors() {
		
		return "Supervisors";
	}

}
