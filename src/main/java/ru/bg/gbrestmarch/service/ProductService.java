package ru.bg.gbrestmarch.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bg.gbrestmarch.controller.dto.ProductDto;
import ru.bg.gbrestmarch.dao.ProductDao;
import ru.bg.gbrestmarch.entity.Product;
import ru.bg.gbrestmarch.entity.enums.Status;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductDao productDao;

    public ProductDto save(ProductDto productDto) {
        Product savingProduct;
        if (productDto.getId() != null) {
            Optional<Product> productFromDBOptional = productDao.findById(productDto.getId());
            savingProduct = productFromDBOptional.orElseGet(Product::new);
        } else {
            savingProduct = new Product();
        }
        savingProduct.setTitle(productDto.getTitle());
        savingProduct.setCost(productDto.getCost());
        savingProduct.setManufactureDate(productDto.getManufactureDate());
        savingProduct.setStatus(productDto.getStatus());
        savingProduct = productDao.save(savingProduct);
        productDto.setId(savingProduct.getId());
        return productDto;
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productDao.findById(id).orElse(null);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        try {
            productDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
        }
    }

    public void disable(Long id) {
        Optional<Product> product = productDao.findById(id);
        product.ifPresent(p -> {
            p.setStatus(Status.DISABLED);
            productDao.save(p);
        });
    }
}
