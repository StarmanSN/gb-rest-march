package ru.bg.gbrestmarch.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.bg.gbrestmarch.controller.dto.ManufacturerDto;
import ru.bg.gbrestmarch.service.ManufacturerApi;
import ru.bg.gbrestmarch.service.ManufacturerGateway;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/manufacturer")
public class ManufacturerController {

//    private final ManufacturerGateway manufacturerGateway;
    private final ManufacturerApi manufacturerApi;

    @GetMapping
    public ManufacturerDto create() {
        return manufacturerApi.create(new ManufacturerDto());
    }

}
