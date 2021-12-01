package com.ssafy.happyhouse.model.service.map;

import com.ssafy.happyhouse.model.dto.map.CctvDto;
import java.util.List;

public interface CctvService {
    List<CctvDto> getCctv(String dong) throws Exception;
}
