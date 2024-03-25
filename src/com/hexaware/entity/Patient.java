package com.hexaware.entity;

import java.time.LocalDate;

public class Patient {
	private int patientId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private String contactNumber;
	private String address;
	
	public Patient() {
		
	}
	
	public Patient(int patientId, String firstName, String lastName, LocalDate dateOfBirth, 
			String gender, String contactNumber, String address) {
		super();
		this.setPatientId(patientId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setDateOfBirth(dateOfBirth);
		this.setGender(gender);
		this.setContactNumber(contactNumber);
		this.setAddress(address);
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return("Patient:"
				+ "\nPatient Id:"+patientId
				+"\nFirst name:"+firstName
				+"\nLast name:"+lastName
				+"\nDate of Birth: "+dateOfBirth
				+"\nGender: "+gender
				+"\nContact number: "+contactNumber
				+"\nAddress: "+ address);
	}
}
