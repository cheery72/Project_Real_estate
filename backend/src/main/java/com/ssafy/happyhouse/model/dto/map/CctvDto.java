package com.ssafy.happyhouse.model.dto.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CctvDto {
    private String addr;
    private int camera;
    private String filming;
    private double lat;
    private double lng;
}
