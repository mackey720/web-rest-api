package com.restapi.managers.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restapi.managers.Managers;
import com.restapi.managers.sorter.FisrtNameSorter;
import com.restapi.managers.sorter.JurisdictionSorter;
import com.restapi.managers.sorter.LastNameSorter;

@Component
public class ManagerDaoService {
	
private static List<Managers> managers = new ArrayList<>();

private static int managerCount = 4;
	
	static {
		managers.add(new Managers(1, "Alicia","McPherson","","","Mickey", "Personal"));
		managers.add(new Managers(2, "Mary","Smith","","", "John Doe", "Diversity"));
		managers.add(new Managers(3, "Dwayne","John","","", "Mickey", "Exclusive"));
		managers.add(new Managers(4, "Dan","Radder","","","John Doe", "Concurrent"));
		
		Collections.sort(managers, new JurisdictionSorter()
				.thenComparing(new LastNameSorter())
				.thenComparing(new FisrtNameSorter()));
	}
	
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
