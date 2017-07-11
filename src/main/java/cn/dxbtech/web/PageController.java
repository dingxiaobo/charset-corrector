package cn.dxbtech.web;

import cn.dxbtech.config.RemoteIpAddress;
import cn.dxbtech.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class PageController {

    private final AccessService accessService;

    @Autowired
    public PageController(AccessService accessService) {
        this.accessService = accessService;
    }

    @GetMapping({"", "/"})
    String pageIndex(@RemoteIpAddress String ip, @RequestHeader("user-agent") String ua) {
        accessService.history("/", ip, ua);
        return "index";
    }
}
