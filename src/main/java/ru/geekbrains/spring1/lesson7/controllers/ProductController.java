package ru.geekbrains.spring1.lesson7.controllers;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring1.lesson7.entities.Product;
import ru.geekbrains.spring1.lesson7.exceptions.AppError;
import ru.geekbrains.spring1.lesson7.exceptions.ResourceNotFoundException;
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



    @GetMapping("/products/change_price")
    public void changeScore(@RequestParam Long productId, @RequestParam Integer delta) {
        System.out.println(productId);
        // studentService.changeScore(studentId, delta);
        productService.changePrice(productId, delta);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/price_between")
    public List<Product> filter(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "100") Integer max){
        return productService.filter(min, max);
    }

    @GetMapping("/products/save")
    public void addNewProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Integer price) {
        Product product = new Product(id, title, price);
        productService.save(product);

    }
}