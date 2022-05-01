package ru.bg.gbrestmarch.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bg.gbrestmarch.controller.dto.ProductDto;
import ru.bg.gbrestmarch.dao.OrderDao;
import ru.bg.gbrestmarch.dao.ProductDao;
import ru.bg.gbrestmarch.entity.Order;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderDao orderDao;
    private final ProductDao productDao;

    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return orderDao.findById(id).orElse(null);
    }

    public void createOrder(Order order) {
        orderDao.save(order);
    }

    public void deleteOrderById(Long id) {
        orderDao.deleteById(id);
    }

    public ProductDto addProduct(ProductDto productDto) {
        if (productDto != null) {
            productDao.findById(productDto.getId());
        }
        return productDto;
    }

    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }
}
