package cn.dxbtech.web.rest;

import cn.dxbtech.service.CorrectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

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
    public String correct(@RequestParam("s") String origin) {
        String result = "失败";
        try {
            result = correctService.correct(origin);
        } catch (UnsupportedEncodingException e) {
            result += e.toString();
            logger.error("{}", e.toString(), e);
        }
        return result;
    }

}
