package com.example.Assigment1_Omar.Service;

import com.example.Assigment1_Omar.DTO.doctorDTO;
import com.example.Assigment1_Omar.Repository.doctorRepository;
import com.example.Assigment1_Omar.model.doctor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class doctorServiceImp implements doctorService {

    private final doctorRepository doctorRepo;

    public doctorServiceImp(doctorRepository doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Object addDoctor(doctorDTO DoctorDTO) {
        if (DoctorDTO.getDoctorName() == null ||
                DoctorDTO.getDoctorDepartment() == null ||
                DoctorDTO.getDoctorSalary() == null ||
                DoctorDTO.getDoctorDateOfBirth() == null ||
                DoctorDTO.getDoctorFullTime() == null ||
                DoctorDTO.getDoctorMobile() == null ||
                DoctorDTO.getDoctorEmail() == null ||
                DoctorDTO.getDoctorAddress() == null) {
            return null;
        } else {
            doctor newDoctor = new doctor();
            newDoctor.setDoctorName(DoctorDTO.getDoctorName());
            newDoctor.setDoctorDepartment(DoctorDTO.getDoctorDepartment());
            newDoctor.setDoctorSalary(DoctorDTO.getDoctorSalary());
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(DoctorDTO.getDoctorDateOfBirth(), format);
            newDoctor.setDoctorDateOfBirth(localDate);
            newDoctor.setDoctorFullTime(DoctorDTO.getDoctorFullTime());
            newDoctor.setDoctorMobile(DoctorDTO.getDoctorMobile());
            newDoctor.setDoctorEmail(DoctorDTO.getDoctorEmail());
            newDoctor.setDoctorAddress(DoctorDTO.getDoctorAddress());
            return doctorRepo.save(newDoctor);
        }
    }

    @Override
    public boolean DeleteApp(int doctorId) {
        Boolean exist = doctorRepo.existsById(doctorId);
        if (!exist) {
            System.out.println("doctor does not exist");
            return false;
        } else {
            doctorRepo.deleteById(doctorId);
            return true;
        }
    }

    @Override
    public List<doctor> getDoctors() {
        return doctorRepo.findAll();
    }

    @Override
    public doctor getDoctorById(int doctorId) {
        return doctorRepo.findByDoctorId(doctorId);
    }

    @Override
    public boolean updateDoctor(doctorDTO myDoctor) {
        System.out.println(myDoctor.toString());
        doctor updateDoctor = doctorRepo.findById(myDoctor.getDoctorId()).orElse(null);
        if (updateDoctor == null) {
            return false;
        }

        if (myDoctor.getDoctorName() != null) {
            updateDoctor.setDoctorName(myDoctor.getDoctorName());
        }

        if (myDoctor.getDoctorDepartment() != null) {
            updateDoctor.setDoctorDepartment(myDoctor.getDoctorDepartment());
        }

        if (myDoctor.getDoctorSalary() != null) {
            updateDoctor.setDoctorSalary(myDoctor.getDoctorSalary());
        }

        if (myDoctor.getDoctorDateOfBirth() != null) {
            System.out.println("dsfsdf");
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            updateDoctor.setDoctorDateOfBirth(LocalDate.parse(myDoctor.getDoctorDateOfBirth(),df));
        }

        if (myDoctor.getDoctorFullTime() != null) {
            updateDoctor.setDoctorFullTime(myDoctor.getDoctorFullTime());
        }

        if (myDoctor.getDoctorMobile() != null) {
            updateDoctor.setDoctorMobile(myDoctor.getDoctorMobile());
        }

        if (myDoctor.getDoctorEmail() != null) {
            updateDoctor.setDoctorEmail(myDoctor.getDoctorEmail());
        }

        if (myDoctor.getDoctorAddress() != null) {
            updateDoctor.setDoctorAddress(myDoctor.getDoctorAddress());
        }
        return true;

    }
}
