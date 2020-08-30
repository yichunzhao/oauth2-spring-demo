package com.ynz.oauth2demo.invoker;

import com.ynz.oauth2demo.dto.GuestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestServiceClient {
    private static final String SLASH = "/";

    @Value("${guests.path}")
    private String guestsPath;

    @Value("${guests.host}")
    private String guestHost;

    private final RestTemplate restTemplate;

    private String guestUri() {
        return guestHost + guestsPath;
    }

    public List<GuestDto> findAll() {
        String url = guestHost + guestsPath;
        ResponseEntity<GuestDto[]> response = restTemplate.getForEntity(url, GuestDto[].class);
        return Arrays.asList(response.getBody());
    }

    public GuestDto addGuest(GuestDto guestDto) {
        return restTemplate.postForObject(guestUri(), guestDto, GuestDto.class);
    }

    public GuestDto findGuestById(Long id) {
        String url = guestUri() + SLASH + id;
        return restTemplate.getForEntity(url, GuestDto.class).getBody();
    }

    public GuestDto updateGuest(Long id, GuestDto guestDto) {
        String url = guestUri() + SLASH + id;
        HttpEntity<GuestDto> requestEntity = new HttpEntity<>(guestDto);
        return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, GuestDto.class).getBody();
    }

}
