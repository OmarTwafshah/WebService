package com.example.Assigment1_Omar.Repository;

import com.example.Assigment1_Omar.model.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface patientRepository extends JpaRepository<patient,Integer> {

    List<patient> findAll();

    patient findByPatientId(int i);
}
