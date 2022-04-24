package ru.bg.gbrestmarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.bg.gbrestmarch.controller.dto.ProductDto;
import ru.bg.gbrestmarch.dao.ManufacturerDao;
import ru.bg.gbrestmarch.dao.ProductDao;
import ru.bg.gbrestmarch.entity.Manufacturer;
import ru.bg.gbrestmarch.service.ProductService;

import java.util.HashSet;

@SpringBootApplication
public class GbRestMarchApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GbRestMarchApplication.class, args);
//        context.getBean(ProductService.class).init();

    }

}
