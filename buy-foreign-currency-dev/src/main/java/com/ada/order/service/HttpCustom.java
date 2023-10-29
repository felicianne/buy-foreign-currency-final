package com.ada.order.service;

import com.ada.order.model.Exchange;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HttpCustom {
    private final RestTemplate restTemplate;

    public HttpCustom() {
        this.restTemplate = new RestTemplate();
    }

    public  Exchange getExchange(String currency) {

        String URL = "https://economia.awesomeapi.com.br/json/" + currency;

        try {
            ResponseEntity<List<Exchange>> response = restTemplate.exchange(
                    URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Exchange>>() {
                    });

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null && !response.getBody().isEmpty()) {
                return response.getBody().get(0);
            } else {
                System.out.println("error");
            }
        } catch (ResponseStatusException ex) {
            throw new ResponseStatusException(ex.getStatusCode(), ex.getMessage());
        }
        return null;
    }
}
