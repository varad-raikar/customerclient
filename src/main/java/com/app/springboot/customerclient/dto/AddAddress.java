package com.app.springboot.customerclient.dto;

import lombok.Data;

@Data
public class AddAddress {
    private int id;

    private String addressType;

    private String address;
}
