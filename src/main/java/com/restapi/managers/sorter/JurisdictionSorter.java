package com.restapi.managers.sorter;

import java.util.Comparator;

import com.restapi.managers.Managers;

public class JurisdictionSorter implements Comparator<Managers> {
	public int compare(Managers  m1, Managers m2) {
		return m1.getJurisdiction().compareTo(m2.getJurisdiction());
	}
}
