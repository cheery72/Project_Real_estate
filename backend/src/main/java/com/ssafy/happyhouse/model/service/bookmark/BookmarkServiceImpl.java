package com.ssafy.happyhouse.model.service.bookmark;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ssafy.happyhouse.model.dto.bookmark.BookmarkDto;
import com.ssafy.happyhouse.model.mapper.bookmark.BookmarkMapper;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    @Autowired
    private SqlSession sqlSession;

	@Override
	@Transactional
	public int deleteBookmark(String userId, Integer aptCode) throws Exception {
		int result = 0;
		result += sqlSession.getMapper(BookmarkMapper.class).deleteBookmark(userId,aptCode);
		return result;
	}

	@Override
	public List<BookmarkDto> listBookmark(String userId) throws Exception {
		return sqlSession.getMapper(BookmarkMapper.class).listBookmark(userId);
	}
	@Override
	@Transactional
	public int addBookmark(BookmarkDto book) throws Exception {
		int result = 0;
		result += sqlSession.getMapper(BookmarkMapper.class).addBookmark(book); // 관심지역 생성

		return result;
	}

}
