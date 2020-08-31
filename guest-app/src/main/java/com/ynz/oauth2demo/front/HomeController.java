package com.ynz.oauth2demo.front;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {
    @GetMapping({"/"})
    public String getHome() {
        log.info("home page");
        return "index";
    }
}
