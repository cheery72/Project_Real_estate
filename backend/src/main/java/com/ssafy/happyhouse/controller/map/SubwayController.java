package com.ssafy.happyhouse.controller.map;

import com.ssafy.happyhouse.model.dto.map.SubwayDto;
import com.ssafy.happyhouse.model.service.map.SubwayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/subway")
public class SubwayController {

    @Autowired
    private SubwayService subwayService;

    @GetMapping("/subwayinfo")
    public ResponseEntity<List<SubwayDto>> getSubway() throws Exception{
        log.info("지하철 정보");
        return new ResponseEntity<List<SubwayDto>>(subwayService.getSubway(), HttpStatus.OK);
    }

}
