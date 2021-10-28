package com.app.springboot.customerclient.Service;

import com.app.springboot.customerclient.dto.AddAddress;
import com.app.springboot.customerclient.dto.CustomerDetails;
import com.app.springboot.customerclient.dto.NewCustomer;
import com.app.springboot.customerclient.dto.NumberUpdate;
import com.app.springboot.customerclient.exception.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
@PropertySource(value="classpath:application.properties")
public class ServiceImpl implements IService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    private HttpHeaders header;
    private ObjectMapper mapper;

    @PostConstruct
    public void init(){
        header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        mapper = new ObjectMapper();
    }

    @Override
    public Object getDetails(int id) throws JsonProcessingException {
        String URL = env.getProperty("get.url") + id;
        HttpStatus status;
        int respCode;

        HttpEntity<?> entity = new HttpEntity<>(header);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
        status = response.getStatusCode();
        respCode = response.getStatusCode().value();

        if (respCode == 200) {
            CustomerDetails details = mapper.readValue(response.getBody(), CustomerDetails.class);
            return details;
        }else {
            ErrorResponse error = mapper.readValue(response.getBody(), ErrorResponse.class);
            return error;
        }
    }

    @Override
    public CustomerDetails newCustomer(NewCustomer customer) {
        String URL = env.getProperty("addCust.url");
        HttpEntity<NewCustomer> entity = new HttpEntity<>(customer, header);
        ResponseEntity<CustomerDetails> response = restTemplate.exchange(URL, HttpMethod.POST, entity, CustomerDetails.class);
        CustomerDetails details = response.getBody();

        return details;
    }

    @Override
    public CustomerDetails updNumber(NumberUpdate newNumber) {
        String URL = env.getProperty("updNum.url");
        HttpEntity<NumberUpdate> entity = new HttpEntity<>(newNumber, header);
        ResponseEntity<CustomerDetails> response = restTemplate.exchange(URL, HttpMethod.PUT, entity, CustomerDetails.class);
        CustomerDetails details = response.getBody();

        return details;
    }

    @Override
    public CustomerDetails addAddress(AddAddress newAddress) {
        String URL = env.getProperty("addAdd.url");
        HttpEntity<AddAddress> entity = new HttpEntity<>(newAddress, header);
        ResponseEntity<CustomerDetails> response = restTemplate.exchange(URL, HttpMethod.POST, entity, CustomerDetails.class);
        CustomerDetails details = response.getBody();

        return details;
    }
}
