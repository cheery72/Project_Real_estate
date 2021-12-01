package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.model.dto.board.CommentDto;
import com.ssafy.happyhouse.model.service.board.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @PostMapping("/register")
    public ResponseEntity<CommentDto> regComment(@RequestBody CommentDto commentDto) throws Exception {
        CommentDto bt = commentService.regComment(commentDto);
        if(ObjectUtils.isEmpty(bt)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bt);
    }

    @GetMapping("/list/{bno}")
    public ResponseEntity<List<CommentDto>> getBoard(@PathVariable int bno) throws Exception {
        return new ResponseEntity<List<CommentDto>>(commentService.getComment(bno), HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modBoard(@RequestBody Map<String,Object> map) throws Exception {
        if(commentService.modComment(map)) {
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.OK);
    }

    @DeleteMapping("/del")
    public ResponseEntity<String> delBoard(@RequestParam Map<String,Object> map) throws Exception {
        if(commentService.delComment(map)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.OK);
    }

}
