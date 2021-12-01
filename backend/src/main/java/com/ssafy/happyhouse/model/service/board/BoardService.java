package com.ssafy.happyhouse.model.service.board;

import com.ssafy.happyhouse.model.dto.board.BoardDto;
import java.util.List;
import java.util.Map;

public interface BoardService {
    BoardDto regBoard(BoardDto boardDto) throws Exception;
    List<BoardDto> getBoard(int aptCode) throws Exception;
    boolean modBoard(Map<String,Object> map) throws Exception;
    boolean delBoard(Map<String,Object> map) throws Exception;
}
