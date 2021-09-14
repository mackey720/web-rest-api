package com.restapi.managers.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.springframework.stereotype.Component;

import com.restapi.managers.Managers;
import com.restapi.managers.sorter.FisrtNameSorter;
import com.restapi.managers.sorter.JurisdictionSorter;
import com.restapi.managers.sorter.LastNameSorter;

@Component
public class ManagerService {
	
private static List<Managers> managers = new ArrayList<>();

private static int managerCount = 4;
	
	static {
		managers.add(new Managers(1, "Alicia","McPherson","","","Mickey", "Personal"));
		managers.add(new Managers(2, "Mary","Smith","","", "John Doe", "Diversity"));
		managers.add(new Managers(3, "Dwayne","John","","", "Mickey", "Exclusive"));
		managers.add(new Managers(4, "Dan","Radder","","","John Doe", "Concurrent"));
		
		/*Collections.sort(managers, new Comparator<Managers>() 
		{		
			public int compare(Managers m1, Managers m2) 
			{
				return new CompareToBuilder().append(m1.getJurisdiction(), m2.getJurisdiction())
						.append(m1.getLastName(), m2.getLastName())
						.append(m1.getFirstName(), m2.getFirstName()).toComparison();
			}
		});*/
	}
	
	public List<Managers> findAll(){
		
		Collections.sort(managers, new JurisdictionSorter()
				.thenComparing(new LastNameSorter())
				.thenComparing(new FisrtNameSorter()));
		
		/*String stringformatter;
		
		for (Managers manager : managers)
		{
			stringformatter  "{" + manager.getJurisdiction() + "}" + " - " + "{" + manager.getLastName() + "}" + ", " + "{" + manager.getFirstName() + "}"; 
		}*/
		
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
