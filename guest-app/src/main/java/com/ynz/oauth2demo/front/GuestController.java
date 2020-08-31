package com.ynz.oauth2demo.front;

import com.ynz.oauth2demo.dto.GuestDto;
import com.ynz.oauth2demo.invoker.GuestServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class GuestController {
    private final GuestServiceClient guestServiceClient;

    @GetMapping("/guests")
    private String getAllGuests(Model model) {
        log.info("guest page");
        List<GuestDto> guests = guestServiceClient.findAll();
        model.addAttribute("guests", guests);
        return "guests";
    }
}
