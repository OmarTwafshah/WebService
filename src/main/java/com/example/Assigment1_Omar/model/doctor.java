package com.example.Assigment1_Omar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity(name = "doctor")
@Table(name = "doctor")
@Data
public class doctor {
    @Id
    @SequenceGenerator(
            name = "doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_sequence"
    )
    @Column(
            name = "doctor_id",
            updatable = false,
            nullable = false
    )
    private Integer doctorId;

    @Column(
            name = "doctor_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String doctorName;

    @Column(
            name = "doctor_department",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String doctorDepartment;

    @Column(
            name = "doctor_salary",
            nullable = false
    )
    private Double doctorSalary;

    @Column(
            name = "doctor_date_of_birth",
            nullable = false
    )
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate doctorDateOfBirth;

    @Column(
            name = "doctor_full_time",
            nullable = false
    )
    private Boolean doctorFullTime;

    @Column(
            name = "doctor_mobile",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String doctorMobile;

    @Column(
            name = "doctor_email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String doctorEmail;

    @Column(
            name = "doctor_address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String doctorAddress;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "doctor_patient_table",
            joinColumns = {
                    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
            }
    )
    @JsonManagedReference
    private Set<patient> patients;

    @JsonIgnore
    @OneToMany(mappedBy = "doctorId",cascade = CascadeType.ALL)
    private Set<appointment> appointments;


}
