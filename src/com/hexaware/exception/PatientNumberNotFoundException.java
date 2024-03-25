package com.hexaware.exception;

@SuppressWarnings("serial")
public class PatientNumberNotFoundException extends Throwable{
	public PatientNumberNotFoundException() {
		System.out.println("Patient number not found");
	}
	public String toString() {
		return "Patient number not found";
	}
}
