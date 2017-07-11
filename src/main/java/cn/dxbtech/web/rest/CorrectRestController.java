package cn.dxbtech.web.rest;

import cn.dxbtech.config.RemoteIpAddress;
import cn.dxbtech.dto.CorrectDto;
import cn.dxbtech.service.CorrectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("correct")
public class CorrectRestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CorrectService correctService;

    @Autowired
    public CorrectRestController(CorrectService correctService) {
        this.correctService = correctService;
    }

    @PostMapping("")
    public Map<String, Object> correct(@RequestParam("s") String origin,
                                       @RemoteIpAddress String ip,
                                       @RequestHeader("user-agent") String ua) {
        Map<String, Object> map = new HashMap<>();
        boolean success = true;
        String error = null;
        try {
            CorrectDto correctDto = correctService.correct(origin, ip, ua);
            if (correctDto == null || StringUtils.isEmpty(correctDto.getResult())) {
                success = false;
                error = "失败 未能找到编码";
            } else if (!StringUtils.isEmpty(correctDto.getResult()) && correctDto.getResult().equals(correctDto.getOrigin())) {
                success = false;
                error = "失败 内容未变化";
            }
            map.put("data", correctDto);
        } catch (UnsupportedEncodingException e) {
            success = false;
            error = "失败" + e.toString();
            logger.error("{}", e.toString(), e);
        }
        map.put("success", success);
        map.put("error", error);
        return map;
    }

}
