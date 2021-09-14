package com.restapi.managers.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restapi.managers.Managers;

@Component
public class ManagerDaoService {
	
private static List<Managers> managers = new ArrayList<>();

private static int managerCount = 4;
	
	static {
		managers.add(new Managers(1, "Alicia","McPherson","","","Mickey", "Personal"));
		managers.add(new Managers(2, "Mary","Smith","","", "John Doe", "Diversity"));
		managers.add(new Managers(3, "Dwayne","John","","", "Mickey", "Exclusive"));
		managers.add(new Managers(4, "Dan","Radder","","","John Doe", "Concurrent"));
	}
	
	//return a list of all the users
	public List<Managers> findAll(){
		return managers;
	}
	
	public Managers save(Managers manager) {
		if(manager.getId()==null) {
			manager.setId(++managerCount);
		}
		managers.add(manager);
		return manager;
	}

}
