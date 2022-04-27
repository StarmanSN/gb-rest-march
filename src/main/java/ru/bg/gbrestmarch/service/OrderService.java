package ru.bg.gbrestmarch.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bg.gbrestmarch.dao.OrderDao;
import ru.bg.gbrestmarch.dao.ProductDao;
import ru.bg.gbrestmarch.entity.Order;
import ru.bg.gbrestmarch.entity.Product;

import java.util.List;
import java.util.Optional;

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

    public Order createOrder(Order order) {
        orderDao.findById(order.getId());
        orderDao.save(order);
        return order;
    }

    public void deleteOrderById(Long id) {
        orderDao.deleteById(id);
    }

    public Product addProduct(Product product) {

        return product;
    }

    public void deleteProduct(Long id) {
        Product product = productDao.getById(id);

    }
}
