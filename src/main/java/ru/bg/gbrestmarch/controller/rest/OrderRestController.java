package ru.bg.gbrestmarch.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bg.gbrestmarch.controller.dto.ProductDto;
import ru.bg.gbrestmarch.entity.Order;
import ru.bg.gbrestmarch.service.OrderGateway;
import ru.bg.gbrestmarch.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderRestController {

    private final OrderService orderService;
    private final OrderGateway orderGateway;

    @GetMapping("/all")
    public List<Order> getOrderList() {
        return orderService.findAll();
    }

    @PostMapping("/create")
    public void createOrder(Order order) {
        orderService.createOrder(order);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable("orderId") Long id) {
        Order order;
        if (id != null) {
            order = orderService.findById(id);
            if (order != null) {
                return new ResponseEntity<>(order, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/removeOrder")
    public void removeOrder() {
        orderGateway.remove();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id) {
        orderService.deleteOrderById(id);
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return orderGateway.getProducts();
    }

    @PutMapping("/addProduct")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return orderService.addProduct(productDto);
    }

    @DeleteMapping("/delete/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("productId") Long id) {
        orderService.deleteProduct(id);
    }
}
