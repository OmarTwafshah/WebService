package com.example.Assigment1_Omar.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class doctorDTO {
    private Integer doctorId;
    private String doctorName;
    private String doctorDepartment;
    private Double doctorSalary;
    private String doctorDateOfBirth;
    private Boolean doctorFullTime;
    private String doctorMobile;
    private String doctorEmail;
    private String doctorAddress;


}
