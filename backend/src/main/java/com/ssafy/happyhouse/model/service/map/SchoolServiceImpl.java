package com.ssafy.happyhouse.model.service.map;

import com.ssafy.happyhouse.model.dto.map.SchoolDto;
import com.ssafy.happyhouse.model.mapper.map.SchoolMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<SchoolDto> getSchool(String dong) throws Exception {
        return sqlSession.getMapper(SchoolMapper.class).getSchool(dong);
    }
}
