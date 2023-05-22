package com.example.Assigment1_Omar.Repository;

import com.example.Assigment1_Omar.model.doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface doctorRepository extends JpaRepository<doctor,Integer> {

    List<doctor> findAll();

    doctor findByDoctorId(int i);
}
