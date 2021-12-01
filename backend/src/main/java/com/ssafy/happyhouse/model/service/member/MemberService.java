package com.ssafy.happyhouse.model.service.member;

import com.ssafy.happyhouse.model.dto.member.MemberDto;

public interface MemberService {
    public MemberDto login(MemberDto memberDto) throws Exception;
    public MemberDto userInfo(String userId) throws Exception;
    boolean registerMember(MemberDto memberDto);
    int idCheck(String id);
    boolean modifyInfo(MemberDto memberDto);
    boolean deleteMember(String id);

}
