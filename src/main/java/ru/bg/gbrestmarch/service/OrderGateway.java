package ru.bg.gbrestmarch.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bg.gbrestmarch.controller.dto.OrderDto;
import ru.bg.gbrestmarch.controller.dto.ProductDto;

import java.util.List;

@FeignClient(url = "localhost:5484/order", value = "orderGateway")
public interface OrderGateway {

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    OrderDto create(@RequestBody OrderDto orderDto);

    @PostMapping("/create")
    OrderDto create(@RequestBody OrderDto orderDto);

    @GetMapping
    List<ProductDto> getProducts();

    @PutMapping("/addProduct")
    ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto);

    @DeleteMapping("/delete/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(@PathVariable("productId") Long id);

    @DeleteMapping("/removeOrder")
    void remove();
}
