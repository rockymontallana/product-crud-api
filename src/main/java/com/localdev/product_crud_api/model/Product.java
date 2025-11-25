package com.localdev.product_crud_api.model;

import lombok.Data;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Integer quantity;
    private BigDecimal amount;
}
