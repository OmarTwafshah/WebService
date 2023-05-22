package com.example.Assigment1_Omar.Service;

import com.example.Assigment1_Omar.DTO.appointmentDTO;
import com.example.Assigment1_Omar.Repository.appointmentRepository;
import com.example.Assigment1_Omar.Repository.doctorRepository;
import com.example.Assigment1_Omar.Repository.patientRepository;
import com.example.Assigment1_Omar.Repository.roomRepository;
import com.example.Assigment1_Omar.model.appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class appointmentServiceImp implements appointmentService {

    private final appointmentRepository appointmentRepo;
    private final doctorRepository doctorRepo;
    private final patientRepository patientRepo;

    private final roomRepository roomRepo;



    @Autowired
    public appointmentServiceImp(appointmentRepository appointmentRepository, doctorRepository doctorRepo, patientRepository patientRepo, roomRepository roomRepo) {
        this.appointmentRepo = appointmentRepository;
        this.doctorRepo = doctorRepo;
        this.patientRepo = patientRepo;
        this.roomRepo = roomRepo;
    }

    @Override
    public Object addappointment(appointmentDTO appointmentDTO) {
        if (appointmentDTO.getAppointmentName() == null ||
                appointmentDTO.getAppointmentType() == null ||
                appointmentDTO.getAppointmentDate() == null ||
                appointmentDTO.getAppointmentDescription() == null) {
            return null;
        } else {
            appointment newAppointment = new appointment();
            newAppointment.setAppointmentName(appointmentDTO.getAppointmentName());
            newAppointment.setAppointmentType(appointmentDTO.getAppointmentType());
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(appointmentDTO.getAppointmentDate(), format);
            newAppointment.setAppointmentDate(localDate);
            newAppointment.setAppointmentDescription(appointmentDTO.getAppointmentDescription());
            newAppointment.setDoctorId(doctorRepo.findByDoctorId(appointmentDTO.getDoctorId()));
            newAppointment.setPatientId(patientRepo.findByPatientId(appointmentDTO.getPatientId()));
            newAppointment.setRoomId(roomRepo.findByRoomId(appointmentDTO.getRoomId()));
            return appointmentRepo.save(newAppointment);
        }
    }

    @Override
    @Transactional
    public boolean DeleteApp(int appointmentId) {
        Boolean exist = appointmentRepo.existsById(appointmentId);
        if (!exist) {
            System.out.println("appointment does not exist");
            return false;
        } else {
            appointmentRepo.deleteById(appointmentId);
            return true;
        }
    }

    @Override
    public List<appointment> getAppointments() {
        return appointmentRepo.findAll();
    }

    @Override
    public appointment getAppointmentById(int appointmentId) {
        return appointmentRepo.findByAppointmentId(appointmentId);
    }

    @Override
    @Transactional
    public boolean updateAppointment(appointmentDTO myappointment) {
        appointment updaetAppointment = appointmentRepo.findById(myappointment.getAppointmentId()).orElse(null);
        if (updaetAppointment == null) {
            return false;
        }

        if (myappointment.getAppointmentName() != null) {
            updaetAppointment.setAppointmentName(myappointment.getAppointmentName());
        }

        if (myappointment.getAppointmentType() != null) {
            updaetAppointment.setAppointmentType(myappointment.getAppointmentType());
        }

        if (myappointment.getAppointmentDate() != null) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            updaetAppointment.setAppointmentDate(LocalDate.parse(myappointment.getAppointmentDate(),df));
        }

        if (myappointment.getAppointmentDescription() != null) {
            updaetAppointment.setAppointmentDescription(myappointment.getAppointmentDescription());
        }
        return true;
    }
}
