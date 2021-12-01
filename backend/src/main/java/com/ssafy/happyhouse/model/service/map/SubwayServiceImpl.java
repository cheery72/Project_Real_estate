package com.ssafy.happyhouse.model.service.map;

import com.ssafy.happyhouse.model.dto.map.SubwayDto;
import com.ssafy.happyhouse.model.mapper.map.SubwayMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubwayServiceImpl implements SubwayService{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<SubwayDto> getSubway() throws Exception {
        return sqlSession.getMapper(SubwayMapper.class).getSubway();
    }

}
