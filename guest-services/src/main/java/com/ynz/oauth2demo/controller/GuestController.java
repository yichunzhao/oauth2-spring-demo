package com.ynz.oauth2demo.controller;

import com.ynz.oauth2demo.dto.GuestDto;
import com.ynz.oauth2demo.dto.GuestMapper;
import com.ynz.oauth2demo.repo.Guest;
import com.ynz.oauth2demo.service.GuestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/guests")
@RequiredArgsConstructor
@Slf4j
public class GuestController {
    private final GuestService service;

    @GetMapping
    public ResponseEntity<List<GuestDto>> getAllGuests() {
        List<GuestDto> guestDtos = service.findAll().stream().map(guest -> GuestMapper.instance().inverse(guest))
                .collect(toList());

        return new ResponseEntity<>(guestDtos, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<GuestDto> addGuest(@RequestBody GuestDto guestDto) {
        Guest persisted = service.persist(GuestMapper.instance().map(guestDto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment("/{id}").buildAndExpand(persisted.getId()).toUri();
        return ResponseEntity.created(location).body(GuestMapper.instance().inverse(persisted));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestDto> getGuest(@PathVariable("id") Long id) {
        Guest found = service.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(GuestMapper.instance().inverse(found));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuestDto> updateGuest(@PathVariable("id") Long id, @RequestBody GuestDto guestDto) {
        Guest updated = service.update(id, GuestMapper.instance().map(guestDto));
        return ResponseEntity.ok(GuestMapper.instance().inverse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGuest(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
