package com.example.Assigment1_Omar.Controller;

import com.example.Assigment1_Omar.DTO.doctorDTO;
import com.example.Assigment1_Omar.Service.doctorService;
import com.example.Assigment1_Omar.model.doctor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class doctorController {
    private final doctorService service ;

    public doctorController(doctorService service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public List<doctor> getdoctors() {
        return service.getDoctors();
    }

    @GetMapping("/get")
    public doctor getDoctorById(@RequestParam(required = true) int id) {
        return service.getDoctorById(id);
    }

    @DeleteMapping(path = "/delete")
    public Boolean deleteDoctor(@RequestParam(required = true) int id) {
        return service.DeleteApp(id);
    }

    @PostMapping("/insert")
    public Object insertAppointment(@RequestBody doctorDTO doctor) {
        System.out.println(doctor.toString());
        doctor mydoctor = (doctor) service.addDoctor(doctor);
        if (mydoctor != null) {
            return true;
        }
        return "One filed is empty";
    }

    @PutMapping("/Update")
    public boolean updateAppointment(@RequestBody doctorDTO doctor) {
        return service.updateDoctor(doctor);
    }


}
