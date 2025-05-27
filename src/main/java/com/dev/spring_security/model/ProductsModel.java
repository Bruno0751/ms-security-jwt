package com.dev.spring_security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "products")
public class ProductsModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducts;

    @NotBlank(message = "O campo 'name' não pode ser vazio. Por favor, forneça um valor válido.")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "O campo 'email' não pode ser null. Por favor, forneça um valor válido.")
    @Column(name = "value", nullable = false)
    private int value;
}
