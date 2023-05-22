package com.example.Assigment1_Omar.DTO;

import lombok.Data;

@Data
public class roomDTO {
    private Integer roomId;
    private Integer roomFloor;
    private Integer roomCapacity;
    private Boolean roomVip;
    private Boolean roomFull;
    private Double roomPricePerday;
}
