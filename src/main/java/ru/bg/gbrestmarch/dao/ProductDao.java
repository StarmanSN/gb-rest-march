package ru.bg.gbrestmarch.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.bg.gbrestmarch.entity.Product;
import ru.bg.gbrestmarch.entity.enums.Status;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Long> {

    Optional<Product> findByTitle(String title);

    List<Product> findAllByTitleContaining(String title);

//    List<Product> findAll(Pageable pageable);

}
