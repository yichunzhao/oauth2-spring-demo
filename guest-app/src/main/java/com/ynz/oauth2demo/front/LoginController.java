package com.ynz.oauth2demo.front;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        log.info("login ");

        return "login";
    }


    @GetMapping("/login-failure")
    public String loginFailure(Model model) {
        log.info("login failure");
        model.addAttribute("loginErr",true);

        return "login";
    }

}
