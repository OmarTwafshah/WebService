package com.example.Assigment1_Omar.Service;

import com.example.Assigment1_Omar.DTO.patientDTO;
import com.example.Assigment1_Omar.Repository.patientRepository;
import com.example.Assigment1_Omar.model.patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class patientServiceImp implements patientService {

    private final patientRepository patientRepo ;

    public patientServiceImp(patientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    @Override
    public Object addPatient(patientDTO PatientDTO) {
        if (PatientDTO.getPatientName() == null ||
                PatientDTO.getPatientDateOfBirth() == null ||
                PatientDTO.getPatientEmail() == null ||
                PatientDTO.getPatientMobile() == null ||
                PatientDTO.getPatientAddress() == null ){
            return null;
        } else {
            patient newPatient = new patient();
            newPatient.setPatientName(PatientDTO.getPatientName());
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(PatientDTO.getPatientDateOfBirth(), format);
            newPatient.setPatientDateOfBirth(localDate);
            newPatient.setPatientMobile(PatientDTO.getPatientMobile());
            newPatient.setPatientEmail(PatientDTO.getPatientEmail());
            newPatient.setPatientAddress(PatientDTO.getPatientAddress());
            return patientRepo.save(newPatient);
        }
    }

    @Override
    public boolean DeleteApp(int patientId) {
        Boolean exist = patientRepo.existsById(patientId);
        if (!exist) {
            System.out.println("patient does not exist");
            return false;
        } else {
            patientRepo.deleteById(patientId);
            return true;
        }
    }

    @Override
    public List<patient> getPatients() {
        return patientRepo.findAll();
    }

    @Override
    public Optional<patient> getPatientById(int patientId) {
        return patientRepo.findById(patientId);
    }

    @Override
    public boolean updatePatient(patientDTO myPatient) {

        patient updatePatient = patientRepo.findById(myPatient.getPatientId()).orElse(null);
        if (updatePatient == null) {
            return false;
        }

        if (myPatient.getPatientName() != null) {
            updatePatient.setPatientName(myPatient.getPatientName());
        }

        if (myPatient.getPatientDateOfBirth() != null) {
            updatePatient.setPatientDateOfBirth(LocalDate.parse(myPatient.getPatientDateOfBirth()));
        }


        if (myPatient.getPatientMobile() != null) {
            updatePatient.setPatientMobile(myPatient.getPatientMobile());
        }

        if (myPatient.getPatientEmail() != null) {
            updatePatient.setPatientEmail(myPatient.getPatientEmail());
        }

        if (myPatient.getPatientAddress() != null) {
            updatePatient.setPatientAddress(myPatient.getPatientAddress());
        }
        return true;
    }
}
