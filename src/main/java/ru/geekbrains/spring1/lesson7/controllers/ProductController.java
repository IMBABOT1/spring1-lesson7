package ru.geekbrains.spring1.lesson7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring1.lesson7.entities.Product;
import ru.geekbrains.spring1.lesson7.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllStudents() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
