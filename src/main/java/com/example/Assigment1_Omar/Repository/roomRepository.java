package com.example.Assigment1_Omar.Repository;

import com.example.Assigment1_Omar.model.room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface roomRepository extends JpaRepository<room,Integer> {

    List<room> findAll();

    room findByRoomId(int i);




}
