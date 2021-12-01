package com.ssafy.happyhouse.model.mapper.board;

import com.ssafy.happyhouse.model.dto.board.CommentDto;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CommentMapper {
    int regComment(CommentDto commentDto) throws SQLException;
    List<CommentDto> getComment(int bno) throws SQLException;
    int modComment(Map<String,Object> map) throws SQLException;
    int delComment(Map<String,Object> map) throws SQLException;

}
