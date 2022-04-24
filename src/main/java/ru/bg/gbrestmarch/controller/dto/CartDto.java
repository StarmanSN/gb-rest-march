package ru.bg.gbrestmarch.controller.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {

    private Long id;
    @NotNull
    private String status = "not empty";
}
