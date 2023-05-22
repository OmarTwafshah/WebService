package com.example.Assigment1_Omar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity(name = "appointment")
@Table(name = "appointment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class appointment {
    @Id
    @SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_sequence"
    )
    @Column(
            name = "appointment_id",
            updatable = false,
            nullable = false
    )
    private Integer appointmentId;

    @Column(
            name = "appointment_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String appointmentName;

    @Column(
            name = "appointment_type",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String appointmentType;

    @Column(
            name = "appointment_date",
            nullable = false
    )
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentDate;

    @Column(
            name = "appointment_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String appointmentDescription;

    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private patient patientId;

    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    private doctor doctorId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    @JsonIgnoreProperties(value = "appointment")
    private room roomId;
}
