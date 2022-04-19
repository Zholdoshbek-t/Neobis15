package com.tilek.spring.neobis.service;

import com.tilek.spring.neobis.entity.Product;
import com.tilek.spring.neobis.exception.ResourceNotFoundException;
import com.tilek.spring.neobis.model.ProductModel;
import com.tilek.spring.neobis.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product was not found"));

        return ResponseEntity.ok(product);
    }

    @Override
    public Product createProduct(ProductModel productModel) {
        Product product = new Product();

        mergeProducts(product, productModel);

        return productRepository.save(product);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Long id, ProductModel productDetails) {
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product was not found"));

        mergeProducts(updateProduct, productDetails);

        productRepository.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }

    @Override
    public ResponseEntity<Product> deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product was not found"));

        productRepository.deleteById(id);

        return ResponseEntity.ok(product);
    }

    private void mergeProducts(Product product, ProductModel productModel) {
        product.setName(productModel.getName());
        product.setPrice(productModel.getPrice());
        product.setAmount(productModel.getAmount());
        product.setWarehouse(productModel.getWarehouse());
    }
}
