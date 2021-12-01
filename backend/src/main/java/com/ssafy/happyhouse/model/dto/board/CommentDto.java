package com.ssafy.happyhouse.model.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private int bno;
    private int rno;
    private String userId;
    private String comments;
    private String regDate;
    private int likes;

    public CommentDto(int bno, String userId, String comments) {
        this.bno = bno;
        this.userId = userId;
        this.comments = comments;
    }

    public CommentDto(int bno, String userId) {
        this.bno = bno;
        this.userId = userId;
    }
}
