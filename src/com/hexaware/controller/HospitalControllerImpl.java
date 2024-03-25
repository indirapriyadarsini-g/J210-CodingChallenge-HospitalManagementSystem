package com.hexaware.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.hexaware.dao.HospitalServiceImpl;
import com.hexaware.dao.IHospitalService;
import com.hexaware.entity.Appointment;
import com.hexaware.exception.PatientNumberNotFoundException;

public class HospitalControllerImpl implements IHospitalController{

	List<Appointment> appointmentList = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	IHospitalService hs = new HospitalServiceImpl();
	
	@Override
	public void getAppointmentById() throws SQLException, PatientNumberNotFoundException {
		System.out.println("Enter appointment Id to view details: ");
		int appointmentId = sc.nextInt();
		Appointment appointment = hs.getAppointmentById(appointmentId);
		System.out.println("Appointment Details: "
				+ "\nAppointment ID: "+appointment.getAppointmentId()
				+ "\nPatient ID: "+appointment.getPatientId()
				+ "\nDoctor ID: "+appointment.getDoctorId()
				+ "\nAppointment Date: "+appointment.getAppointmentDate()
				+ "\nDescription: "+appointment.getDescription());
		
	}

	@Override
	public void getAppointmentsForPatient() throws SQLException, PatientNumberNotFoundException {
		System.out.println("Enter Patient Id: ");
		int patientId = sc.nextInt();
		List<Appointment> appointmentListForPatient = hs.getAppointmentsForPatient(patientId);
		for(Appointment appointment:appointmentListForPatient) {
			System.out.println(appointment.toString());
		}
		
	}

	@Override
	public void getAppointmentsForDoctor() throws SQLException, PatientNumberNotFoundException {
		System.out.println("Enter Doctor Id: ");
		int doctorId = sc.nextInt();
		Set<Appointment> appointmentListForDoctor = new HashSet<>(hs.getAppointmentsForDoctor(doctorId));
		if(appointmentListForDoctor!=null) {
		for(Appointment appointment:appointmentListForDoctor) {
			System.out.println(appointment.toString());
		}}
		
	}

	@Override
	public void scheduleAppointment() throws SQLException {
		
		System.out.println("Enter Appointment Id: ");
		int appointmentId = sc.nextInt();
		System.out.println("Enter Patient Id: ");
		int patientId = sc.nextInt();
		System.out.println("Enter Doctor Id: ");
		int doctorId = sc.nextInt();
		System.out.println("Enter Appointment Date (YYYY-MM-DD) : ");
		LocalDate appointmentDate = LocalDate.parse(sc.next());
		System.out.println("Enter Description: ");
		sc.nextLine();
		String description = sc.nextLine();
		Appointment appointment = new Appointment(appointmentId,patientId,doctorId,appointmentDate,description);
		if(hs.scheduleAppointment(appointment)) {
			appointmentList.add(appointment);
			System.out.println("Appointment scheduled successfully.");
		}
		
	}

	@Override
	public void updateAppointment() throws SQLException {
		System.out.println("Enter appointment Id to update:");
		int appointmentId = sc.nextInt();
		
		System.out.println("Enter updated Patient Id: ");
		int patientId = sc.nextInt();
		System.out.println("Enter updated Doctor Id: ");
		int doctorId = sc.nextInt();
		System.out.println("Enter updated Appointment Date (YYYY-MM-DD) : ");
		LocalDate appointmentDate = LocalDate.parse(sc.next());
		System.out.println("Enter updated Description: ");
		sc.nextLine();
		String description = sc.nextLine();
		
		Appointment appointment = new Appointment(appointmentId,patientId,doctorId,appointmentDate,description);
		if(hs.updateAppointment(appointment)) {
			System.out.println("Updated successfully");
			System.out.println(appointment.toString());
		}				
			
	}
		
		
		

	@Override
	public void cancelAppointment() throws SQLException {
		System.out.println("Enter appointment Id to cancel: ");
		int appointmentId = sc.nextInt();
		if(hs.cancelAppointment(appointmentId)) {
			System.out.println("Appointment canceled successfully");
		}
		
	}

}
