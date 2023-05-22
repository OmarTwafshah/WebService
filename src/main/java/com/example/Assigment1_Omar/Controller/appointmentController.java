package com.example.Assigment1_Omar.Controller;

import com.example.Assigment1_Omar.DTO.appointmentDTO;
import com.example.Assigment1_Omar.Service.appointmentService;
import com.example.Assigment1_Omar.Service.appointmentServiceImp;
import com.example.Assigment1_Omar.model.appointment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin
public class appointmentController {

    private final appointmentService service;


    public appointmentController(appointmentServiceImp appointmentService) {
        this.service = appointmentService;
    }

    @GetMapping("/getall")
    public List<appointment> getAppointments() {
        return service.getAppointments();
    }

    @GetMapping("/get")
    public appointment getAppointmentById(@RequestParam(required = true) int id) {
        return service.getAppointmentById(id);
    }

    @DeleteMapping(path = "/delete")
    public Boolean deleteAppointment(@RequestParam(required = true) int id) {
        return service.DeleteApp(id);
    }

    @PostMapping("/insert")
    public Object insertAppointment(@RequestBody appointmentDTO appointment) {
        System.out.println(appointment.toString());
        appointment myAppointment = (appointment) service.addappointment(appointment);
        if (myAppointment != null) {
            return true;
        }
        return "One filed is empty";
    }

    @PutMapping("/Update")
    public boolean updateAppointment(@RequestBody appointmentDTO appointment) {
        return service.updateAppointment(appointment);
    }

}
