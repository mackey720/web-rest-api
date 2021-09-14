package com.restapi.managers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restapi.managers.dao.ManagerService;


@RestController
public class ManagerJPAResource {
	
	@Autowired
	private ManagerService service;
	
	@Autowired
	private ManagersRepository managerRepository;
	
	
	@GetMapping("/api/managers")
	public List<Managers> retrieveAllManagers(){
		return managerRepository.findAll();
	}
	
	@PostMapping("api/submit")
	public ResponseEntity<Object> createManager(@Valid @RequestBody Managers manager) {
		
		Managers savedManager = managerRepository.save(manager);
		
		//get current request URI
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedManager.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
