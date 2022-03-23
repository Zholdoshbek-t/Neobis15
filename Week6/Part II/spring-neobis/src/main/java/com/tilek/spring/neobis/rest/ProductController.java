package com.tilek.spring.neobis.rest;

import com.tilek.spring.neobis.entity.Product;
import com.tilek.spring.neobis.model.ProductModel;
import com.tilek.spring.neobis.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('product:read')")
    List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('product:read')")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('product:write')")
    Product createProduct(@RequestBody ProductModel productModel) {
        return productService.createProduct(productModel);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('product:write')")
    ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductModel productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('product:write')")
    ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
