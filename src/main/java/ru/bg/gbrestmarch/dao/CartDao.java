package ru.bg.gbrestmarch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bg.gbrestmarch.entity.Cart;


public interface CartDao extends JpaRepository<Cart, Long> {

//    Cart save(Cart cart);
}
