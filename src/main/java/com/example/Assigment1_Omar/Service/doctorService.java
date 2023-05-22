package com.example.Assigment1_Omar.Service;

import com.example.Assigment1_Omar.DTO.doctorDTO;
import com.example.Assigment1_Omar.model.doctor;

import java.util.List;

public interface doctorService {

    Object addDoctor(doctorDTO newDoctor);

    boolean DeleteApp(int doctorId);

    List<doctor> getDoctors();

    doctor getDoctorById(int doctorId);

    boolean updateDoctor(doctorDTO myDoctor);



}
