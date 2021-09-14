package com.restapi.managers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restapi.managers.service.ManagerService;


@RestController
public class ManagerJPAResource {
	
	@Autowired
	private ManagerService service;
	
	@Autowired
	private ManagersRepository managerRepository;
	
	@Value("${aws.api}")
	private String strURI;
	
	
	@GetMapping("/api/managers")
	public List<String> retrieveAllManagers(){
		List<Managers> managers = managerRepository.findAll();
		return service.sortManagers(managers);
	}
	
	@GetMapping("/api/supervisors")
	public List<String> retrieveAllSupervisors(){
		List<Managers> listOfManagers = new ArrayList<>();
		
		ResponseEntity<List<Managers>> responseEntity = new RestTemplate().exchange(strURI, HttpMethod.GET, null, new ParameterizedTypeReference<List<Managers>>() {});
		
		listOfManagers = responseEntity.getBody();	
		return service.sortManagers(listOfManagers);
	}
	
	
	@PostMapping("api/submit")
	public ResponseEntity<Object> createManager(@Valid @RequestBody Managers manager) {
		
		Managers savedManager = managerRepository.save(manager);
		service.printToConsole(savedManager);
		
		//get current request URI
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedManager.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
