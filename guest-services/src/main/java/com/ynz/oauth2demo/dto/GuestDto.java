package com.ynz.oauth2demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GuestDto {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String country;
    private String state;
    private String phoneNumber;

}
