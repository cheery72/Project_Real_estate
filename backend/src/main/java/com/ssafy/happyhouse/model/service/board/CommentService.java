package com.ssafy.happyhouse.model.service.board;

import com.ssafy.happyhouse.model.dto.board.CommentDto;
import java.util.List;
import java.util.Map;

public interface CommentService {
    CommentDto regComment(CommentDto commentDto) throws Exception;
    List<CommentDto> getComment(int bno) throws Exception;
    boolean modComment(Map<String,Object> map) throws Exception;
    boolean delComment(Map<String,Object> map) throws Exception;
}
