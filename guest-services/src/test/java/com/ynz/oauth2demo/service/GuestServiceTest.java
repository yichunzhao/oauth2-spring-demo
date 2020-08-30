package com.ynz.oauth2demo.service;

import com.ynz.oauth2demo.repo.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class GuestServiceTest {
    @Autowired
    private GuestService service;

    @Test
    void persist() {
        Guest guest = Guest.builder().state("NY").phoneNumber("12345678").lastName("Zhao").firstName("Yichun")
                .emailAddress("Ynz@mail.com").country("XX").address("xyz").build();
        Guest persisted = service.persist(guest);

        assertThat(persisted,is(notNullValue()));
        assertThat(persisted.getAddress(),is("xyz"));
    }
}