package com.ssafy.happyhouse.model.service.member;

import com.ssafy.happyhouse.model.dto.member.MemberDto;
import com.ssafy.happyhouse.model.mapper.member.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public MemberDto login(MemberDto memberDto) throws Exception {
        if(memberDto.getUserId() == null || memberDto.getUserPwd() == null)
            return null;
        return sqlSession.getMapper(MemberMapper.class).login(memberDto);
    }

    @Override
    public MemberDto userInfo(String userId) throws Exception {
        return sqlSession.getMapper(MemberMapper.class).userInfo(userId);
    }

    @Override
    public boolean registerMember(MemberDto memberDto) {
        return sqlSession.getMapper(MemberMapper.class).registerMember(memberDto) == 1;
    }

    @Override
    public int idCheck(String id) {
        return sqlSession.getMapper(MemberMapper.class).idCheck(id);
    }

    @Override
    public boolean modifyInfo(MemberDto memberDto) {
        return sqlSession.getMapper(MemberMapper.class).modifyInfo(memberDto) == 1;
    }

    @Override
    public boolean deleteMember(String userId) {
        return sqlSession.getMapper(MemberMapper.class).deleteMember(userId) == 1;
    }

}
