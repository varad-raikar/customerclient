package com.app.springboot.customerclient.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDetails {
    private int customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String contactNo;

    private List<AddressDetails> addressResponses;

    private String subscriptionType;
}
