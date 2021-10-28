package com.app.springboot.customerclient.dto;

import lombok.Data;

@Data
public class NewCustomer {

    private String firstName;

    private String lastName;

    private String email;

    private String contactNo;

    private String addressType;

    private String address;

    private String subscriptionType;
}
