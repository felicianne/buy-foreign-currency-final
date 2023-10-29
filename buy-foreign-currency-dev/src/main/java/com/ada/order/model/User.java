package com.ada.order.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "user")
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false, unique = true)
    private String cpf;

    @Column (nullable = false)
    private Double dataDeNascimento;

    @Column (nullable = false)
    private String estadoCivil;

    @Column (nullable = false)
    private String sexo;

    @Column (nullable = false)
    private String senha;
}
