package com.ssafy.happyhouse.controller.map;


import com.ssafy.happyhouse.model.dto.map.SchoolDto;
import com.ssafy.happyhouse.model.service.map.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/school")
@Slf4j
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/schoolinfo")
    public ResponseEntity<List<SchoolDto>> getSchool (@RequestParam String dong) throws Exception{
        return new ResponseEntity<List<SchoolDto>>(schoolService.getSchool(dong), HttpStatus.OK);
    }
}
