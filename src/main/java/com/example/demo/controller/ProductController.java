package com.example.demo.controller;

import com.example.demo.models.Product;
import com.example.demo.models.ResponseObject;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    //Get all product
    @RequestMapping("/Products")
    List<Product> getAllProduct() {
        return repository.findAll();
    }

    //Get product by id
    @RequestMapping("/Product/{id}")
    ResponseEntity<ResponseObject> getProductById(@PathVariable Long id) {
        Optional<Product> foundProduct = repository.findById(id);
        if (!foundProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find product with id = "+id, "")
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query product successfully", foundProduct)
        );
    }

    //Create new product
    @PostMapping("/Product")
    ResponseEntity<ResponseObject> createProduct(@RequestBody Product newProduct) {
        List<Product> foundProducts = repository.findByProductName(newProduct.getProductName().trim());
        if (foundProducts.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Product name already taken", "")
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Create product successfully", repository.save(newProduct))
        );
    }

    //Update product
    @PutMapping("/Product/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        Optional<Product> foundProduct = repository.findById(id);
        List<Product> foundProducts = repository.findByProductName(newProduct.getProductName().trim());

        if (foundProduct.isPresent()) {
            if (foundProducts.size() > 0) {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Product name already taken", "")
                );
            }

            Optional<Product> productUpdate = foundProduct.map(product -> {
                product.setProductName(newProduct.getProductName());
                product.setDescription(newProduct.getDescription());
                product.setPrice(newProduct.getPrice());
                product.setUrl(newProduct.getUrl());
                return repository.save(product);
            });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Update product successfully", productUpdate)
            );

        } else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Cannot find product with id = "+id, "")
            );
        }
    }

    //Delete product
    @DeleteMapping("/Product/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if (!exists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find product with id = "+id, "")
            );
        }

        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Delete product successfully", "")
        );
    }
}
