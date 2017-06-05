package com.holiday.shared;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class RestTemplateFactory {

    final private RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity getForEntity(URI uri, Class clazz) {
        return restTemplate.getForEntity(uri, clazz);
    }
}
