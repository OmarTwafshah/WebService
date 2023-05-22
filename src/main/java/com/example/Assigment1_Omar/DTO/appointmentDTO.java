package com.example.Assigment1_Omar.DTO;
import lombok.Data;

@Data
public class appointmentDTO {
    private Integer appointmentId;
    private String appointmentName;
    private String appointmentType;
    private String appointmentDate;
    private String appointmentDescription;
    private Integer patientId;
    private Integer doctorId;
    private Integer roomId;


}
