package ru.bg.gbrestmarch.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bg.gbrestmarch.dao.CartDao;
import ru.bg.gbrestmarch.dao.ProductDao;
import ru.bg.gbrestmarch.entity.Cart;
import ru.bg.gbrestmarch.entity.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final ProductDao productDao;
    private final CartDao cartDao;

    @Transactional
    public List<Cart> findAllInCart() {
        return cartDao.findAll();
    }

    public Product addToCart(Long id) {
        Cart cart = cartDao.getById(1L);
        Product product = productDao.getById(id);
        cart.addProduct(product);
        cartDao.save(cart);
        return product;
    }

    public void deleteFromCart(Long id) {
        Cart cart = cartDao.getById(1L);
        cart.getProducts().removeIf(product -> product.getId().equals(id));
    }
}
