package com.ssafy.happyhouse.model.mapper.map;

import com.ssafy.happyhouse.model.dto.map.CctvDto;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;

@Mapper
public interface CctvMapper {
    List<CctvDto> getCctv(String dong) throws SQLException;

}
