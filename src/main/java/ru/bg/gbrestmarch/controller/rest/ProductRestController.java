package ru.bg.gbrestmarch.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.bg.gbrestmarch.controller.dto.CartDto;
import ru.bg.gbrestmarch.controller.dto.ProductDto;
import ru.bg.gbrestmarch.entity.Cart;
import ru.bg.gbrestmarch.entity.Product;
import ru.bg.gbrestmarch.service.CartService;
import ru.bg.gbrestmarch.service.ProductService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductRestController {

    private final ProductService productService;
    private final CartService cartService;

    @GetMapping
    public List<Product> getProductList() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable("productId") Long id) {
        Product product;
        if (id != null) {
            product = productService.findById(id);
            if (product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> handlePost(@Validated @RequestBody ProductDto productDto) {
        ProductDto savedProductDto = productService.save(productDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/api/v1/product/" + savedProductDto.getId()));
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> handleUpdate(@PathVariable("productId") Long id, @Validated @RequestBody ProductDto productDto) {
        productDto.setId(id);
        ProductDto savedProductDto = productService.save(productDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/api/v1/product/" + savedProductDto.getId()));
        return new ResponseEntity<>(httpHeaders, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("productId") Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/cart")
    public List<Cart> cartList() {
        return cartService.findAllInCart();
    }

    @PutMapping("/cart/{productId}")
    public ResponseEntity<?> addHandle(@PathVariable("productId") Long id, @Validated @RequestBody CartDto cartDto, ProductDto productDto) {
        cartDto.setId(id);
        Product addedProduct = cartService.addToCart(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/api/v1/product/cart" + addedProduct.getId()));
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping("/cart/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFromCart(@PathVariable("productId") Long id) {
        cartService.deleteFromCart(id);
    }
}
