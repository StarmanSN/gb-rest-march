package ru.bg.gbrestmarch.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.bg.gbrestmarch.controller.dto.ManufacturerDto;

@FeignClient(url = "localhost:5484/manufacturer", value = "ManufacturerGateway")
public interface ManufacturerGateway {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ManufacturerDto create(@RequestBody ManufacturerDto manufacturerDto);

}
