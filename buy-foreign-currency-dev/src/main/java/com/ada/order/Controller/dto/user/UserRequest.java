package com.ada.order.controller.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
public class UserRequest {
    @NotBlank()
    @Length(min = 3, max = 35)
    private String name;
    private String cpf;
    private Double dataDeNascimento;
    private String estadoCivil;
    private String sexo;
    private String senha;
}
