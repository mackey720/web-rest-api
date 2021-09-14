package com.restapi.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ManagerDaoService {
	
private static List<Managers> managers = new ArrayList<>();

private static int managerCount = 4;
	
	static {
		managers.add(new Managers(1, "Alicia","McPherson", "Personal"));
		managers.add(new Managers(2, "Mary","Smith", "Diversity"));
		managers.add(new Managers(3, "Dwayne","John", "Exclusive"));
		managers.add(new Managers(4, "Dan","Radder", "Concurrent"));
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
