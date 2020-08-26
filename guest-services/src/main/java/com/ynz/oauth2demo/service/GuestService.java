package com.ynz.oauth2demo.service;

import com.ynz.oauth2demo.exceptions.GuestNotFoundException;
import com.ynz.oauth2demo.repo.Guest;
import com.ynz.oauth2demo.repo.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository repository;

    public List<Guest> findAll() {
        List<Guest> guests = new ArrayList<>();
        repository.findAll().forEach(guest -> guests.add(guest));

        return guests;
    }

    public Guest findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new GuestNotFoundException("Guest is not found: " + id));
    }

    public Guest persist(Guest guest) {
        return repository.save(guest);
    }

    public Guest update(Long id, Guest guest) {
        findById(id);
        guest.setId(id);

        return repository.save(guest);
    }

    public void delete(Long id) {
        findById(id);
        repository.existsById(id);
    }

}
