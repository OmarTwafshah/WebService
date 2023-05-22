package com.example.Assigment1_Omar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "room")
@Table(name = "room")
@Data
public class room {
    @Id
    @SequenceGenerator(
            name = "room_sequence",
            sequenceName = "room_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_sequence"
    )
    @Column(
            name = "room_id",
            updatable = false,
            nullable = false
    )
    private Integer roomId;

    @Column(
            name = "room_floor",
            nullable = false
    )
    private Integer roomFloor;

    @Column(
            name = "room_capacity",
            nullable = false
    )
    private Integer roomCapacity;

    @Column(
            name = "room_vip",
            nullable = false
    )
    private Boolean roomVip;

    @Column(
            name = "room_full",
            nullable = false
    )
    private Boolean roomFull;

    @Column(
            name = "room_price_per_day",
            nullable = false
    )
    private Double roomPricePerday;

    @OneToOne(mappedBy = "roomId")
    @JsonIgnoreProperties(value = "room")
    @JsonIgnore
    private appointment appointmentId;


}
