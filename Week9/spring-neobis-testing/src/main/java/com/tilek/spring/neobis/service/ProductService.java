package com.tilek.spring.neobis.service;

import com.tilek.spring.neobis.entity.Product;
import com.tilek.spring.neobis.model.ProductModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();
    ResponseEntity<Product> getProductById(Long id);
    Product createProduct(ProductModel productModel);
    ResponseEntity<Product> updateProduct(Long id, ProductModel productDetails);
    ResponseEntity<Product> deleteProduct(Long id);

}
