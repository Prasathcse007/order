package com.maersk.order.rest;

import com.maersk.order.bo.CheckResponse;
import com.maersk.order.bo.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Service
public class RestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("space.available.check")
    private String endpoint;

    public Integer checkAvailable(OrderRequest orderRequest){
        try{
            ResponseEntity<CheckResponse> responseEntity = restTemplate.exchange(endpoint, HttpMethod.POST
                    , new HttpEntity<>(orderRequest, new HttpHeaders()), CheckResponse.class);
            return responseEntity.getBody().getAvailableSpace();
        } catch (HttpClientErrorException ex){
            return null;
        } catch (RestClientException ex){
            return null;
        }

    }
}
