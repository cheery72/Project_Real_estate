package com.ssafy.happyhouse.controller.map;

import com.ssafy.happyhouse.model.dto.map.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.map.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.map.AptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api("Apt 컨트롤러 API V1")
@Slf4j
@RestController
@RequestMapping("/apt")
public class AptController {

    @Autowired
    private AptService aptService;

    @ApiOperation(value = "시도 정보", notes = "전국의 시도를 반환한다.", response = List.class)
    @GetMapping("/sido")
    public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception{
        log.info("sido 호출");
        return new ResponseEntity<List<SidoGugunCodeDto>>(aptService.getSido(),HttpStatus.OK);
    }

    @ApiOperation(value = "구군 정보", notes = "전국의 구군을 반환한다.", response = List.class)
    @GetMapping("/gugun")
    public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") @ApiParam(value = "시도코드.", required = true) String sido) throws Exception{
        System.out.println(sido);
        log.info("gugun 호출");
        return new ResponseEntity<List<SidoGugunCodeDto>>(aptService.getGugunInSido(sido),HttpStatus.OK);
    }

    @ApiOperation(value = "동 정보", notes = "해당 구군의 동이름을 반환한다.", response = List.class)
    @GetMapping("/dongname")
    public ResponseEntity<List<HouseInfoDto>> dongName(@RequestParam("gugun") @ApiParam(value = "동이름", required = true) String gugun) throws Exception{
        log.info("gugun 호출");
        return new ResponseEntity<List<HouseInfoDto>>(aptService.getDongName(gugun),HttpStatus.OK);
    }

	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(aptService.getDongInGugun(gugun), HttpStatus.OK);
	}

	@GetMapping("/aptinfo")
	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong) throws Exception {
        log.info("동은?",dong);
		return new ResponseEntity<List<HouseInfoDto>>(aptService.getAptInDong(dong), HttpStatus.OK);
	}

}
