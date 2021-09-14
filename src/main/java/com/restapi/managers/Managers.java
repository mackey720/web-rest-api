package com.restapi.managers;

import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

public class Managers {
	
	private Integer Id;
	
	@Size(min=2)
	private String firstName;
	
	@Size(min=2)
	private String lastName;
	
	@Email
	private String emailAddress;
	private String phoneNumber;
	private String supervisor;
	private String jurisdiction;
	
	protected Managers() {
		
	}
	
	
	public Managers(Integer id, @Size(min = 2) String firstName, @Size(min = 2) String lastName,
			@Email String emailAddress, String phoneNumber, String supervisor, String jurisdiction) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.supervisor = supervisor;
		this.jurisdiction = jurisdiction;
	}


	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getJurisdiction() {
		return jurisdiction;
	}


	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}




	@Override
	public String toString() {
		return "Managers [" + (Id != null ? "Id=" + Id + ", " : "")
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (emailAddress != null ? "emailAddress=" + emailAddress + ", " : "")
				+ (phoneNumber != null ? "phoneNumber=" + phoneNumber + ", " : "")
				+ (supervisor != null ? "supervisor=" + supervisor + ", " : "")
				+ (jurisdiction != null ? "jurisdiction=" + jurisdiction : "") + "]";
	}

	
}
