package com.holiday.service;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
class RestTemplateFactory {

    @Getter
    final private RestTemplate restTemplate = new RestTemplate();

    ResponseEntity getForEntity(URI uri, Class clazz) {
        return restTemplate.getForEntity(uri, clazz);
    }
}
