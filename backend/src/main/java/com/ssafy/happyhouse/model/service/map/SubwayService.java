package com.ssafy.happyhouse.model.service.map;

import com.ssafy.happyhouse.model.dto.map.SubwayDto;
import java.util.List;

public interface SubwayService {
    List<SubwayDto> getSubway() throws Exception;
}
