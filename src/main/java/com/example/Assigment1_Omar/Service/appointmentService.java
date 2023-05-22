package com.example.Assigment1_Omar.Service;

import com.example.Assigment1_Omar.DTO.appointmentDTO;
import com.example.Assigment1_Omar.model.appointment;
import com.example.Assigment1_Omar.model.doctor;

import java.util.List;

public interface appointmentService {

    Object addappointment(appointmentDTO appointmentDTO);

    boolean DeleteApp(int appointmentId);

    List<appointment> getAppointments();

    appointment getAppointmentById(int appointmentId);

    boolean updateAppointment(appointmentDTO myappointment);







}
