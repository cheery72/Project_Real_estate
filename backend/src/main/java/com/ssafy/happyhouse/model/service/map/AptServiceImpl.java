package com.ssafy.happyhouse.model.service.map;

import com.ssafy.happyhouse.model.dto.map.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.map.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.mapper.map.AptMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class AptServiceImpl implements AptService{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<SidoGugunCodeDto> getSido() throws Exception {
        return sqlSession.getMapper(AptMapper.class).getSido();
    }

    @Override
    public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
        return sqlSession.getMapper(AptMapper.class).getGugunInSido(sido);
    }

    @Override
    public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
        return sqlSession.getMapper(AptMapper.class).getDongInGugun(gugun);
    }

    @Override
    public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
        return sqlSession.getMapper(AptMapper.class).getAptInDong(dong);
    }

    @Override
    public List<HouseInfoDto> getDongName(String gugun) throws SQLException {
        return sqlSession.getMapper(AptMapper.class).getDongName(gugun);
    }
}
