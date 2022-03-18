package com.tilek.spring.neobis.rest;

import com.tilek.spring.neobis.exception.ResourceNotFoundException;
import com.tilek.spring.neobis.model.Product;
import com.tilek.spring.neobis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('product:read')")
    List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('product:read')")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No product found with id: " + id));
        return ResponseEntity.ok(product);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('product:write')")
    Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('product:write')")
    ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No product found with id: " + id));

        updateProduct.setName(productDetails.getName());
        updateProduct.setAmount(productDetails.getAmount());
        updateProduct.setPrice(productDetails.getPrice());

        productRepository.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('product:write')")
    ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No product found with id L " + id));

        productRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
