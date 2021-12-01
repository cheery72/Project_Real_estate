package com.ssafy.happyhouse.model.dto.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
    private String name;
    private String addr;
    private double lat;
    private double lng;
}
