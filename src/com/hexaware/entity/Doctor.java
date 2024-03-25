package com.hexaware.entity;

public class Doctor {
    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String contactNumber;

    public Doctor() {
    	
    }
    
    public Doctor(int doctorId, String firstName, String lastName, String specialization, String contactNumber) {
    	super();
        this.setDoctorId(doctorId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSpecialization(specialization);
        this.setContactNumber(contactNumber);
    }

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

    
    public String toString() {
    	return ("Doctor:"
    			+ "\nDoctor Id: "+doctorId
    			+ "\nFirst name: "+firstName
    			+ "\nLast name: "+lastName
    			+ "\nSpecialization: "+specialization
    			+ "\nContact number: "+contactNumber);
    }
    
    
    
}
