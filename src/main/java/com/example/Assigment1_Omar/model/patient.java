package com.example.Assigment1_Omar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity(name = "patient")
@Table(name = "patient")
@Data
public class patient {
    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    @Column(
            name = "patient_id",
            updatable = false,
            nullable = false
    )
    private Integer patientId;

    @Column(
            name = "patient_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String patientName;

    @Column(
            name = "patient_date_of_birth",
            nullable = false
    )
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate patientDateOfBirth;

    @Column(
            name = "patient_mobile",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String patientMobile;

    @Column(
            name = "patient_email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String patientEmail;

    @Column(
            name = "patient_address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String patientAddress;

    @ManyToMany(mappedBy = "patients",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<doctor> doctors ;

    @JsonIgnore
    @OneToMany(mappedBy = "patientId",cascade = CascadeType.ALL)
    private Set<appointment> appointments;


}
