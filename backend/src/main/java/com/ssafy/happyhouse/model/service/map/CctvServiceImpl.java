package com.ssafy.happyhouse.model.service.map;

import com.ssafy.happyhouse.model.dto.map.CctvDto;
import com.ssafy.happyhouse.model.mapper.map.CctvMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CctvServiceImpl implements CctvService{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<CctvDto> getCctv(String dong) throws Exception {
        return sqlSession.getMapper(CctvMapper.class).getCctv(dong);
    }
}
