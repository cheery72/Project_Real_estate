package com.ssafy.happyhouse.controller.map;

import com.ssafy.happyhouse.model.dto.map.CctvDto;
import com.ssafy.happyhouse.model.service.map.CctvService;
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
@Slf4j
@RequestMapping("/cctv")
public class CctvController {

    @Autowired
    private CctvService cctvService;

    @GetMapping("/cctvinfo")
    public ResponseEntity<List<CctvDto>> getSubway(@RequestParam("dong") String dong) throws Exception{
        log.info("CCTV 정보");
        return new ResponseEntity<List<CctvDto>>(cctvService.getCctv(dong), HttpStatus.OK);
    }

}
