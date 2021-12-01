package com.ssafy.happyhouse.model.mapper.bookmark;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ssafy.happyhouse.model.dto.bookmark.BookmarkDto;

@Mapper
public interface BookmarkMapper {
	public int deleteBookmark(String userId, Integer aptCode) throws SQLException;
	List<BookmarkDto> listBookmark(String userid) throws SQLException;
	public int addBookmark(BookmarkDto bookmark) throws SQLException;
}
