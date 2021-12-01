package com.ssafy.happyhouse.model.mapper.map;

import com.ssafy.happyhouse.model.dto.map.SchoolDto;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;

@Mapper
public interface SchoolMapper {
    List<SchoolDto> getSchool(String dong) throws SQLException;
}
