package com.ynz.oauth2demo.invoker;

import com.ynz.oauth2demo.dto.GuestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class GuestServiceClientTest {
    @Autowired
    private GuestServiceClient client;

    @Test
    public void testFindAllGuest() {
        List<GuestDto> guests = client.findAll();
        assertThat(guests, is(notNullValue()));
        assertThat(guests.size(), is(greaterThan(100)));
    }

    @Test
    public void testFindGuestById() {
        GuestDto guest = client.findGuestById(1L);
        assertThat(guest, is(notNullValue()));
        assertThat(guest.getFirstName(), is("Roy"));
        assertThat(guest.getLastName(), is("Adams"));
        assertThat(guest.getEmailAddress(), is("radams1v@xinhuanet.com"));
    }

    @Test
    public void testAddGuest() {
        GuestDto guest = GuestDto.builder().state("XX").phoneNumber("12345678").lastName("Zhao").firstName("Yichun")
                .emailAddress("ynz@mail.com").country("US").build();

        GuestDto added = client.addGuest(guest);
        assertThat(added, is(notNullValue()));
        assertThat(added, is(equalTo(guest)));
    }

    @Test
    public void testUpdateGuest() {
        GuestDto guest = GuestDto.builder().state("XX").phoneNumber("12345678").lastName("Zhao").firstName("Yichun")
                .emailAddress("ynz@mail.com").country("US").build();
        GuestDto update = client.updateGuest(1L, guest);
        assertThat(update, is(notNullValue()));
        assertThat(update.getFirstName(), is("Yichun"));
    }


}