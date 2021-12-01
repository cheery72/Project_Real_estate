package com.ssafy.happyhouse.model.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "MemberDto : 회원정보", description = "회원의 상세 정보를 나타낸다.")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    @ApiModelProperty(value = "회원 아이디")
    private String userId;
    @ApiModelProperty(value = "회원 이름")
    private String userName;
    @ApiModelProperty(value = "회원 비밀번호")
    private String userPwd;
    @ApiModelProperty(value = "회원 이메일")
    private String email;
    @ApiModelProperty(value = "회원 가입일")
    private String joinDate;
    private int delFlag;


}
