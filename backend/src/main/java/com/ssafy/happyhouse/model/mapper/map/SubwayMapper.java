package com.ssafy.happyhouse.model.mapper.map;

import com.ssafy.happyhouse.model.dto.map.SubwayDto;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;

@Mapper
public interface SubwayMapper {
    List<SubwayDto> getSubway() throws SQLException;
}
