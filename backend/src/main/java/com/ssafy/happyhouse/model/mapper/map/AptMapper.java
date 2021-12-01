package com.ssafy.happyhouse.model.mapper.map;

import com.ssafy.happyhouse.model.dto.map.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.map.SidoGugunCodeDto;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AptMapper  {
    List<SidoGugunCodeDto> getSido() throws SQLException;
    List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;
    List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;
    List<HouseInfoDto> getAptInDong(String dong) throws SQLException;
    List<HouseInfoDto> getDongName(String gugun) throws SQLException;
}
