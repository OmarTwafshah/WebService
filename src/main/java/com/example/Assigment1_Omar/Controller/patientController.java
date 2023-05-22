package com.example.Assigment1_Omar.Controller;

import com.example.Assigment1_Omar.DTO.patientDTO;
import com.example.Assigment1_Omar.Service.patientService;
import com.example.Assigment1_Omar.model.patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class patientController {

    private final patientService service;

    public patientController(patientService service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public List<patient> getPatients() {
        return service.getPatients();
    }

    @GetMapping("/get")
    public Optional<patient> getPatientById(@RequestParam(required = true) int id) {
        return service.getPatientById(id);
    }

    @DeleteMapping(path = "/delete")
    public Boolean deletePatient(@RequestParam(required = true) int id) {
        return service.DeleteApp(id);
    }

    @PostMapping("/insert")
    public Object insertAppointment(@RequestBody patientDTO patient) {
        System.out.println(patient.toString());
        patient mypatient = (patient) service.addPatient(patient);
        if (mypatient != null) {
            return true;
        }
        return "One filed is empty";
    }

    @PutMapping("/Update")
    public boolean updateAppointment(@RequestBody patientDTO patient) {
        return service.updatePatient(patient);
    }
}
