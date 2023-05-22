package com.example.Assigment1_Omar.Repository;

import com.example.Assigment1_Omar.model.appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface appointmentRepository extends JpaRepository<appointment, Integer> {

    List<appointment> findAll();

    appointment findByAppointmentId(int i);

}
