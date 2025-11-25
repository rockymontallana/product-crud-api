package com.localdev.product_crud_api.service;

import com.localdev.product_crud_api.model.Product;
import com.localdev.product_crud_api.repository.ProductDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productDao.findById(id);
    }

    public Product createProduct(Product product) {
        return productDao.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productDao.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            product.setProductName(productDetails.getProductName());
            product.setQuantity(productDetails.getQuantity());
            product.setAmount(productDetails.getAmount());

            return productDao.save(product);
        } else {
            return null;
        }
    }

    public boolean deleteProduct(Long id) {
        if (productDao.existsById(id)) {
            productDao.deleteById(id);
            return true; // Indicate successful deletion
        } else {
            return false; // Indicate the product was not found
        }
    }
}
