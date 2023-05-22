package com.example.Assigment1_Omar.Controller;

import com.example.Assigment1_Omar.DTO.patientDTO;
import com.example.Assigment1_Omar.DTO.roomDTO;
import com.example.Assigment1_Omar.Service.roomService;
import com.example.Assigment1_Omar.model.patient;
import com.example.Assigment1_Omar.model.room;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@CrossOrigin
public class roomController {

    private final roomService service;

    public roomController(roomService service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public List<room> getRooms() {
        return service.getRooms();
    }

    @GetMapping("/get")
    public room getRoomById(@RequestParam(required = true) int id) {
        return service.getRoomById(id);
    }

    @DeleteMapping(path = "/delete")
    public Boolean deleteRoom(@RequestParam(required = true) int id) {
        return service.DeleteApp(id);
    }
    @PostMapping("/insert")
    public Object insertAppointment(@RequestBody roomDTO room) {
        System.out.println(room.toString());
        room myroom = (room) service.addRoom(room);
        if (myroom != null) {
            return true;
        }
        return "One filed is empty";
    }

    @PutMapping("/Update")
    public boolean updateAppointment(@RequestBody roomDTO room) {
        return service.updateRoom(room);
    }

}
