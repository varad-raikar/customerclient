package com.app.springboot.customerclient.Service;

import com.app.springboot.customerclient.dto.AddAddress;
import com.app.springboot.customerclient.dto.CustomerDetails;
import com.app.springboot.customerclient.dto.NewCustomer;
import com.app.springboot.customerclient.dto.NumberUpdate;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface IService {
    Object getDetails (int id) throws JsonProcessingException;
    CustomerDetails newCustomer(NewCustomer customer);
    CustomerDetails updNumber(NumberUpdate newNumber);
    CustomerDetails addAddress(AddAddress newAddress);

}
