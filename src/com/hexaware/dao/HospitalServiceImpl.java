package com.hexaware.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;


import com.hexaware.entity.Appointment;
import com.hexaware.exception.PatientNumberNotFoundException;
import com.hexaware.util.DBConnection;

public class HospitalServiceImpl implements IHospitalService{

	Connection conn;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	

	
	
	@Override
	public Appointment getAppointmentById(int appointmentId) throws SQLException,PatientNumberNotFoundException{
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement("select * from appointment where appointment_id = ?;");
		ps.setInt(1, appointmentId);
		
		rs = ps.executeQuery();
		Appointment appointment = new Appointment();
		while(rs.next()) {
			appointment.setAppointmentId(rs.getInt(1));
			appointment.setPatientId(rs.getInt(2));
			appointment.setDoctorId(rs.getInt(3));
			appointment.setAppointmentDate(LocalDate.parse(rs.getDate(4).toString()));
			appointment.setDescription(rs.getNString(5));
		}
		conn.close();
		return appointment;
	}

	@Override
	public List<Appointment> getAppointmentsForPatient(int patientId) throws SQLException, PatientNumberNotFoundException {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement("select * from appointment where patient_id = ?;");
		ps.setInt(1, patientId);
		
		rs = ps.executeQuery();
		
		List<Appointment> appointmentListForPatient = new ArrayList<>();
		
		if(!rs.next()) {
			throw new PatientNumberNotFoundException();
		}
		
		do{
			Appointment appointment = new Appointment();
			appointment.setAppointmentId(rs.getInt(1));
			appointment.setPatientId(rs.getInt(2));
			appointment.setDoctorId(rs.getInt(3));
			appointment.setAppointmentDate(LocalDate.parse(rs.getDate(4).toString()));
			appointment.setDescription(rs.getNString(5));
			System.out.println(appointment.toString());
			appointmentListForPatient.add(appointment);
			
		}
		while(rs.next());
		conn.close();
		return appointmentListForPatient;
	}

	@Override
	public List<Appointment> getAppointmentsForDoctor(int doctorId) throws SQLException {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement("select * from appointment where doctor_id = ?;");
		ps.setInt(1, doctorId);
		
		rs = ps.executeQuery();
		
		List<Appointment> appointmentListForDoctor = new ArrayList<>();
		
		if(!rs.next()) {
			System.out.println("Doctor ID not found");
			return null;
		}
		
		do{
			Appointment appointment = new Appointment();
			appointment.setAppointmentId(rs.getInt(1));
			appointment.setPatientId(rs.getInt(2));
			appointment.setDoctorId(rs.getInt(3));
			appointment.setAppointmentDate(LocalDate.parse(rs.getDate(4).toString()));
			appointment.setDescription(rs.getNString(5));
			System.out.println(appointment.toString());
			appointmentListForDoctor.add(appointment);
			
		}
		while(rs.next());
		conn.close();
		return appointmentListForDoctor;
	}

	@Override
	public boolean scheduleAppointment(Appointment appointment) throws SQLException {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement("insert into appointment values(?,?,?,?,?);");
		ps.setInt(1, appointment.getAppointmentId());
		ps.setInt(2, appointment.getPatientId());
		ps.setInt(3, appointment.getDoctorId());
		ps.setDate(4, java.sql.Date.valueOf(appointment.getAppointmentDate()));
		ps.setNString(5, appointment.getDescription());
		
		int n = ps.executeUpdate();
		System.out.println(n+" rows affected");
		
		if(n>0) return true;
		else return false;
		
	}

	@Override
	public boolean updateAppointment(Appointment appointment) throws SQLException {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement("update appointment set patient_id = ?,"
				+ "doctor_id = ?,"
				+ "appointment_date = ?,"
				+ "description = ?"
				+ "where appointment_id = ?;");
		ps.setInt(5, appointment.getAppointmentId());
		ps.setInt(1, appointment.getPatientId());
		ps.setInt(2, appointment.getDoctorId());
		ps.setDate(3, java.sql.Date.valueOf(appointment.getAppointmentDate()));
		ps.setNString(4, appointment.getDescription());
		
		int n = ps.executeUpdate();
		System.out.println(n+" rows affected");
		
		if(n>0) return true;
		else return false;
	}

	@Override
	public boolean cancelAppointment(int appointmentId) throws SQLException {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement("delete from appointment where appointment_id = ?");
		ps.setInt(1,appointmentId);
		
		
		int n = ps.executeUpdate();
		System.out.println(n+" rows affected");
		
		if(n>0) return true;
		else return false;
	}
	
}
