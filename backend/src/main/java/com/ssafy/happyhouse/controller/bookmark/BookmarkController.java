package com.ssafy.happyhouse.controller.bookmark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ssafy.happyhouse.model.dto.bookmark.BookmarkDto;
import com.ssafy.happyhouse.model.service.bookmark.BookmarkService;
import com.ssafy.happyhouse.model.service.member.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bookmark")
@CrossOrigin("*")
public class BookmarkController {

	@Autowired
	BookmarkService bookmarkService;
	
	@Autowired
	JwtService jwtService;
	
	@PostMapping("/register")
	@ApiOperation(value="BookmarkDto를 받아 관심 지역 등록 서비스")
	public ResponseEntity<Map<String, Object>> createBookmark(@RequestBody Map<String, Object> info) throws Exception {
		ResponseEntity<Map<String, Object>> resEntity = null;
		int aptCode=(int)info.get("bookmark");
		String userid=(String) info.get("accesstoken");

		try {
			BookmarkDto bookmark = new BookmarkDto(aptCode,userid);
			int insert = bookmarkService.addBookmark(bookmark);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", insert);
			map.put("isSuccess", true);
			map.put("code", 200);
			map.put("message", "관심 지역 등록 성공");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

		} catch(RuntimeException e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isSuccess", false);
			map.put("code", 500);
			map.put("message", "관심 지역 등록 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resEntity;
	}
	
	@GetMapping("/list/{userid}")
	@ApiOperation(value="관심 지역 조회 서비스")
	public ResponseEntity<Map<String, Object>> selectBookmark(@PathVariable("userid") String userId) throws Exception {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> req = new HashMap<String, Object>();

		try {
			List<BookmarkDto> list = bookmarkService.listBookmark(userId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", list);
			map.put("isSuccess", true);
			map.put("code", 200);
			map.put("message", "관심 지역 조회 성공");
		

			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isSuccess", false);
			map.put("code", 500);
			map.put("message", "관심 지역 조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return resEntity;
	}
	
	@DeleteMapping("/list/{userid}/{aptcode}")
	@ApiOperation(value="userIdx와 매물 일련번호를 받아 관심 지역 삭제 서비스")
	public ResponseEntity<Map<String, Object>> deleteBookmark(@PathVariable("userid") String userId, @PathVariable("aptcode") Integer aptCode) throws Exception {
		ResponseEntity<Map<String, Object>> resEntity = null;
		
		try {

			int delete = bookmarkService.deleteBookmark(userId, aptCode);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", delete);
			map.put("isSuccess", true);
			map.put("code", 200);
			map.put("message", "관심 지역 삭제 성공");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isSuccess", false);
			map.put("code", 500);
			map.put("message", "관심 지역 삭제 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resEntity;
	}
}