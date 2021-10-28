package com.app.springboot.customerclient.controller;

import com.app.springboot.customerclient.Service.IService;
import com.app.springboot.customerclient.dto.AddAddress;
import com.app.springboot.customerclient.dto.CustomerDetails;
import com.app.springboot.customerclient.dto.NewCustomer;
import com.app.springboot.customerclient.dto.NumberUpdate;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/")
public class CustomerClientAPI {

    @Autowired
    private IService service;

    @GetMapping("searchById/{customerId}")
    public Object getDetails(@PathVariable int customerId) throws JsonProcessingException {
        return service.getDetails(customerId);
    }

    @PostMapping("create")
    public CustomerDetails newCustomer(@RequestBody NewCustomer newCustomer){
        return service.newCustomer(newCustomer);
    }

    @PutMapping("updNumber")
    public CustomerDetails updNumber(@RequestBody NumberUpdate newNumber){
        return service.updNumber(newNumber);
    }

    @PostMapping("addAddress")
    public CustomerDetails addAddress(@RequestBody AddAddress newAddress){
        return service.addAddress(newAddress);
    }
}
