package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.model.dto.board.BoardDto;
import com.ssafy.happyhouse.model.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @PostMapping("/register")
    public ResponseEntity<BoardDto> regBoard(@RequestBody BoardDto boardDto) throws Exception {
        BoardDto bt = boardService.regBoard(boardDto);
        if(ObjectUtils.isEmpty(bt)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bt);
    }

    @GetMapping("/list/{aptcode}")
    public ResponseEntity<List<BoardDto>> getBoard(@PathVariable("aptcode") int aptCode) throws Exception {
        return new ResponseEntity<List<BoardDto>>(boardService.getBoard(aptCode), HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modBoard(@RequestBody Map<String,Object> map) throws Exception {
        if(boardService.modBoard(map)) {
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.OK);
    }

    @DeleteMapping("/del")
    public ResponseEntity<String> delBoard(@RequestParam Map<String,Object> map) throws Exception {
        if(boardService.delBoard(map)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.OK);
    }
}
