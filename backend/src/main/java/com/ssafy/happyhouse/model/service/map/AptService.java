package com.ssafy.happyhouse.model.service.map;

import com.ssafy.happyhouse.model.dto.map.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.map.SidoGugunCodeDto;
import java.sql.SQLException;
import java.util.List;

public interface AptService {
    List<SidoGugunCodeDto> getSido() throws Exception;
    List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
    List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
    List<HouseInfoDto> getAptInDong(String dong) throws Exception;
    List<HouseInfoDto> getDongName(String gugun) throws SQLException;
}
