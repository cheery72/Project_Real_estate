package com.ssafy.happyhouse.model.dto.bookmark;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "관심지역 DTO", description = "관심 매물의 아파트일련번호, 회원아이디")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkDto {

	@ApiModelProperty(value = "아파트일련번호")
    private int aptCode;
	@ApiModelProperty(value = "회원 아이디")
    private String userId;

    @ApiModelProperty(value = "아파트이름")
    private String aptName;
    @ApiModelProperty(value = "건축년도")
    private int buildYear;
    @ApiModelProperty(value = "동코드")
    private String dongCode;
    @ApiModelProperty(value = "동이름")
    private String dongName;

    @ApiModelProperty(value = "지번")
    private String jibun;
    @ApiModelProperty(value = "위도")
    private String lat;
    @ApiModelProperty(value = "경도")
    private String lng;

    public BookmarkDto(int aptCode, String userId) {
        this.aptCode = aptCode;
        this.userId = userId;
    }

    public BookmarkDto(String aptName, int buildYear, String dongCode, String dongName, String jibun, String lat, String lng) {
        this.aptName = aptName;
        this.buildYear = buildYear;
        this.dongCode = dongCode;
        this.dongName = dongName;
        this.jibun = jibun;
        this.lat = lat;
        this.lng = lng;
    }
}
