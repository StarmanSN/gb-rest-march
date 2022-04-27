package ru.bg.gbrestmarch.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bg.gbrestmarch.controller.dto.ProductDto;
import ru.bg.gbrestmarch.entity.Order;
import ru.bg.gbrestmarch.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderRestController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> getOrderList() {
        return orderService.findAll();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable("orderId") Long id) {
        Order order;
        if (id != null) {
            order = orderService.findById(id);
            if (order != null) {
                return new ResponseEntity<>(order, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id) {
        orderService.deleteOrderById(id);
    }
}
