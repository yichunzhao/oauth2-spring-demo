package com.ynz.oauth2demo.dto;

import com.ynz.oauth2demo.repo.Guest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "instance")
public class GuestMapper implements Mapper<GuestDto, Guest> {
    @Override
    public Guest map(GuestDto guestDto) {
        return Guest.builder().address(guestDto.getAddress()).country(guestDto.getCountry())
                .emailAddress(guestDto.getEmailAddress()).firstName(guestDto.getFirstName())
                .lastName(guestDto.getLastName()).phoneNumber(guestDto.getPhoneNumber())
                .state(guestDto.getState()).build();
    }

    @Override
    public GuestDto inverse(Guest guest) {
        return GuestDto.builder().address(guest.getAddress()).country(guest.getCountry())
                .emailAddress(guest.getEmailAddress()).firstName(guest.getFirstName())
                .lastName(guest.getLastName()).phoneNumber(guest.getPhoneNumber())
                .state(guest.getState()).build();
    }

}
