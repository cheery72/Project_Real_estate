package com.ssafy.happyhouse.model.service.board;

import com.ssafy.happyhouse.model.dto.board.BoardDto;
import com.ssafy.happyhouse.model.mapper.board.BoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public BoardDto regBoard(BoardDto boardDto) throws Exception{
        sqlSession.getMapper(BoardMapper.class).regBoard(boardDto);
        return boardDto;
    }

    @Override
    public List<BoardDto> getBoard(int aptCode) throws Exception {
        return sqlSession.getMapper(BoardMapper.class).getBoard(aptCode);
    }

    @Override
    public boolean modBoard(Map<String,Object> map) throws Exception {
        return sqlSession.getMapper(BoardMapper.class).modBoard(map) == 1;
    }

    @Override
    public boolean delBoard(Map<String,Object> map) throws Exception {
        return sqlSession.getMapper(BoardMapper.class).delBoard(map) == 1;
    }
}
