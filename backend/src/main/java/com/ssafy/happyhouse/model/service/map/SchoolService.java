package com.ssafy.happyhouse.model.service.map;

import com.ssafy.happyhouse.model.dto.map.SchoolDto;
import java.sql.SQLException;
import java.util.List;

public interface SchoolService {
    List<SchoolDto> getSchool(String dong) throws Exception;
}
