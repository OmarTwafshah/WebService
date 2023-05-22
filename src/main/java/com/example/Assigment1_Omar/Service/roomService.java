package com.example.Assigment1_Omar.Service;

import com.example.Assigment1_Omar.DTO.roomDTO;
import com.example.Assigment1_Omar.model.room;

import java.util.List;

public interface roomService {

    Object addRoom(roomDTO newRoom);

    boolean DeleteApp(int roomId);

    List<room> getRooms();

    room getRoomById(int roomId);

    boolean updateRoom(roomDTO myRoom);
}
