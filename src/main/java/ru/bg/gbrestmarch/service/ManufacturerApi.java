package ru.bg.gbrestmarch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.bg.gbrestmarch.controller.dto.ManufacturerDto;

import java.net.URI;

@Component
public class ManufacturerApi {

    public static final String URL = "http://localhost:5484/manufacturer";

    private final RestTemplate restTemplate;

    @Autowired
    public ManufacturerApi(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ManufacturerDto create(ManufacturerDto manufacturerDto) {
        return restTemplate.postForObject(URI.create(URL), manufacturerDto, ManufacturerDto.class);
    }
}
