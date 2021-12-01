package com.ssafy.happyhouse.model.mapper.board;

import com.ssafy.happyhouse.model.dto.board.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    int regBoard(BoardDto boardDto) throws SQLException;
    List<BoardDto> getBoard(int aptCode) throws SQLException;
    int modBoard(Map<String,Object> map) throws SQLException;
    int delBoard(Map<String,Object> map) throws SQLException;
}
