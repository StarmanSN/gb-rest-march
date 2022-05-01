package ru.bg.gbrestmarch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bg.gbrestmarch.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

}
