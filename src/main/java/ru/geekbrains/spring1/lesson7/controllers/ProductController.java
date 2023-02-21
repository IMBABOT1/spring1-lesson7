package ru.geekbrains.spring1.lesson7.controllers;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring1.lesson7.entities.Product;
import ru.geekbrains.spring1.lesson7.exceptions.AppError;
import ru.geekbrains.spring1.lesson7.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring1.lesson7.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllStudents() {
        return productService.findAll();
    }

    @GetMapping("/change_price")
    public void changeScore(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changePrice(productId, delta);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/price_between")
    public List<Product> filter(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "100") Integer max){
        return productService.filter(min, max);
    }

    @PutMapping
    public Product updateStudent(@RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping
    public Product saveNewStudent(@RequestBody Product product) {
        product.setId(null);
        return productService.save(product);
    }


}