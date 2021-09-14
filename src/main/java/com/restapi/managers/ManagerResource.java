package com.restapi.managers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class ManagerResource {
	
	@Autowired
	private ManagerDaoService service;
	
	@GetMapping("/api/managers")
	public List<Managers> retrieveAllManagers(){
		return service.findAll();
	}
	
	@PostMapping("api/submit")
	public ResponseEntity<Object> createManager(@RequestBody Managers manager) {
		
		Managers savedManager = service.save(manager);
		
		//get current request URI
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedManager.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}