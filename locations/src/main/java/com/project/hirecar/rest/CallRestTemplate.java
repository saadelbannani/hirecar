package com.project.hirecar.rest;

import com.project.hirecar.rest.dto.input.LocationCarInputDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class CallRestTemplate {

    @Value("${cars.getbyuuid.url}")
    private String url;

    public ResponseEntity<LocationCarInputDto> getCarByUuid(String uuid) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("params", httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url + uuid, HttpMethod.GET,
                entity, LocationCarInputDto.class);
    }
}
