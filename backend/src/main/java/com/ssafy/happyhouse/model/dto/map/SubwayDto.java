package com.ssafy.happyhouse.model.dto.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubwayDto {
    private String line;
    private String name;
    private String code;
    private double lat;
    private double lng;
}
