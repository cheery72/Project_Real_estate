package com.ssafy.happyhouse.model.mapper.member;

import java.sql.SQLException;
import com.ssafy.happyhouse.model.dto.member.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public MemberDto login(MemberDto memberDto) throws SQLException;
    public MemberDto userInfo(String userId) throws SQLException;
    int registerMember(MemberDto memberDto);
    int idCheck(String id);
    int modifyInfo(MemberDto memberDto);
    int deleteMember(String id);
}
