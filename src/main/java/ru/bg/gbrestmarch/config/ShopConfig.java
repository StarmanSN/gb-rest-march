package ru.bg.gbrestmarch.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import ru.bg.gbrestmarch.entity.Order;
import ru.bg.gbrestmarch.service.ManufacturerGateway;
import ru.bg.gbrestmarch.service.OrderGateway;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
@EnableFeignClients(basePackageClasses = OrderGateway.class)
public class ShopConfig {

    @Bean
    public AuditorAware<String> auditorAwareBean() {
        return () -> Optional.of("User");
    }
}
