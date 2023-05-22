package com.example.Assigment1_Omar.Service;


import com.example.Assigment1_Omar.DTO.patientDTO;
import com.example.Assigment1_Omar.model.patient;

import java.util.List;
import java.util.Optional;

public interface patientService {

    Object addPatient(patientDTO newPatient);

    boolean DeleteApp(int patientId);

    List<patient> getPatients();

    Optional<patient> getPatientById(int patientId);

    boolean updatePatient(patientDTO myPatient);

}
