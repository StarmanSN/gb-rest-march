package ru.bg.gbrestmarch.controller.dto;

import lombok.*;
import ru.bg.gbrestmarch.entity.enums.Status;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    @NotBlank
    private String title;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal cost;
    @PastOrPresent
    private LocalDate manufactureDate;
    @NotNull
    private Status status;
}
