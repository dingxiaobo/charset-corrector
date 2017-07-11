package cn.dxbtech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping({"", "/"})
    String pageIndex() {
        return "index";
    }
}
