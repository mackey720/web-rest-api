package com.restapi.managers;

public class Managers {
	
	private Integer Id;
	private String firstName;
	private String lastName;
	private Email emailAddress;
	private Phone phoneNumber;
	private String supervisor;
	private String jurisdiction;
	

	public Managers(Integer Id, String firstName, String lastName, String jurisdiction) {
		super();
		this.Id = Id;
		this.jurisdiction = jurisdiction;
		this.firstName = firstName;
		this.lastName = lastName;	
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
	

	public Phone getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(Phone phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public Email getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(Email emailAddress) {
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
