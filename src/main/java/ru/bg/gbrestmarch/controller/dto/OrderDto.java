package ru.bg.gbrestmarch.controller.dto;

import lombok.*;
import ru.bg.gbrestmarch.entity.Product;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Long id;
    @PastOrPresent
    private LocalDate orderDate;
    @NotNull
    private Product product;
    @NotNull
    private int quantity;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private double cost;
    @NotNull
    private double amount;
}
