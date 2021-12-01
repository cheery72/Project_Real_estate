package com.ssafy.happyhouse.model.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int bno;
    private String userId;
    private String content;
    private int likes;
    private String regDate;
    private int aptCode;

    public BoardDto(String userId, int aptCode) {
        this.userId = userId;
        this.aptCode = aptCode;
    }

    public BoardDto(String userId, String content, int aptCode) {
        this.userId = userId;
        this.content = content;
        this.aptCode = aptCode;
    }

}
