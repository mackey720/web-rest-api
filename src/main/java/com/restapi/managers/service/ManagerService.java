package com.restapi.managers.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import com.restapi.managers.Managers;
import com.restapi.managers.sorter.FisrtNameSorter;
import com.restapi.managers.sorter.JurisdictionSorter;
import com.restapi.managers.sorter.LastNameSorter;

@Component
public class ManagerService {
	
	public List<String> sortManagers(List<Managers> managers){
		List<String> sortedManagers = new ArrayList<>();
		
		Collections.sort(managers, new JurisdictionSorter()
				.thenComparing(new LastNameSorter())
				.thenComparing(new FisrtNameSorter()));
		
		for (Managers manager : managers)
		{
			if(!NumberUtils.isDigits(manager.getJurisdiction()))
			{
				sortedManagers.add("{" + manager.getJurisdiction() + "}" 
						+ " - " + "{" + manager.getLastName() + "}" 
						+ ", " + "{" + manager.getFirstName() + "}");
			}
		}
		
		return sortedManagers;
	}
	
	public void printToConsole(Managers manager) {
		System.out.println("FrstName: "+ manager.getFirstName() + "\n Last Name: " 
				+ manager.getLastName() + "\n Supervisor: " + manager.getSupervisor());
	}

}
