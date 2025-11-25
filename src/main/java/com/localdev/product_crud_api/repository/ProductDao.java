package com.localdev.product_crud_api.repository;

import com.localdev.product_crud_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
