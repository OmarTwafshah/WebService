package com.example.Assigment1_Omar.Service;

import com.example.Assigment1_Omar.DTO.roomDTO;
import com.example.Assigment1_Omar.Repository.roomRepository;
import com.example.Assigment1_Omar.model.room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class roomServiceImp implements roomService{

    private final roomRepository roomRepo;

    public roomServiceImp(roomRepository roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public Object addRoom(roomDTO RoomDTO) {
        if (RoomDTO.getRoomFloor() == null ||
                RoomDTO.getRoomCapacity() == null ||
                RoomDTO.getRoomVip() == null ||
                RoomDTO.getRoomFull() == null||
                RoomDTO.getRoomPricePerday() == null) {
            return null;
        } else {
            room newRoom = new room();
            newRoom.setRoomFloor(RoomDTO.getRoomFloor());
            newRoom.setRoomCapacity(RoomDTO.getRoomCapacity());
            newRoom.setRoomVip(RoomDTO.getRoomVip());
            newRoom.setRoomFull(RoomDTO.getRoomFull());
            newRoom.setRoomPricePerday(RoomDTO.getRoomPricePerday());
            return roomRepo.save(newRoom);
        }
    }

    @Override
    public boolean DeleteApp(int roomId) {
        Boolean exist = roomRepo.existsById(roomId);
        if (!exist) {
            System.out.println("room does not exist");
            return false;
        } else {
            roomRepo.deleteById(roomId);
            return true;
        }
    }

    @Override
    public List<room> getRooms() {
        return roomRepo.findAll();
    }

    @Override
    public room getRoomById(int roomId) {
        return roomRepo.findByRoomId(roomId);
    }

    @Override
    public boolean updateRoom(roomDTO myRoom) {

        room updaetRoom = roomRepo.findById(myRoom.getRoomId()).orElse(null);
        if (updaetRoom == null) {
            return false;
        }

        if (myRoom.getRoomFloor() != null) {
            updaetRoom.setRoomFloor(myRoom.getRoomFloor());
        }

        if (myRoom.getRoomCapacity() != null) {
            updaetRoom.setRoomCapacity(myRoom.getRoomCapacity());
        }

        if (myRoom.getRoomVip() != null) {
            updaetRoom.setRoomVip(myRoom.getRoomVip());
        }

        if (myRoom.getRoomFull() != null) {
            updaetRoom.setRoomFull(myRoom.getRoomFull());
        }

        if (myRoom.getRoomPricePerday() != null) {
            updaetRoom.setRoomPricePerday(myRoom.getRoomPricePerday());
        }
        return true;
    }
}
