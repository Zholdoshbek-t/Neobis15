package com.tilek.spring.neobis.service;

import com.tilek.spring.neobis.entity.Product;
import com.tilek.spring.neobis.model.ProductModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();
    ResponseEntity<Product> getProductById(Long id);
    Product createProduct(ProductModel productModel);
    ResponseEntity<Product> updateProduct(Long id, ProductModel productDetails);
    ResponseEntity<Product> deleteProduct(Long id);

}
