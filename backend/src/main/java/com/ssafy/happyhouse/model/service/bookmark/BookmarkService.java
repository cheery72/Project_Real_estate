package com.ssafy.happyhouse.model.service.bookmark;

import java.util.List;
import com.ssafy.happyhouse.model.dto.bookmark.BookmarkDto;

public interface BookmarkService {
	public int deleteBookmark(String userId, Integer aptCode) throws Exception;
	public List<BookmarkDto> listBookmark(String userId) throws Exception;
	public int addBookmark(BookmarkDto bookmark) throws Exception;
}
