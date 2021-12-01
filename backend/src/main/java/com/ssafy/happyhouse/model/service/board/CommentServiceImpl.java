package com.ssafy.happyhouse.model.service.board;

import com.ssafy.happyhouse.model.dto.board.CommentDto;
import com.ssafy.happyhouse.model.mapper.board.CommentMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public CommentDto regComment(CommentDto commentDto) throws Exception{
        sqlSession.getMapper(CommentMapper.class).regComment(commentDto);
        return commentDto;
    }

    @Override
    public List<CommentDto> getComment(int bno) throws Exception {
        return sqlSession.getMapper(CommentMapper.class).getComment(bno);
    }

    @Override
    public boolean modComment(Map<String,Object> map) throws Exception {
        return sqlSession.getMapper(CommentMapper.class).modComment(map) == 1;
    }

    @Override
    public boolean delComment(Map<String,Object> map) throws Exception {
        return sqlSession.getMapper(CommentMapper.class).delComment(map) == 1;
    }
}
