package ru.geekbrains.spring1.lesson7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring1.lesson7.entities.Product;
import ru.geekbrains.spring1.lesson7.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> filter(Integer min, Integer max) {
        return productRepository.findAllByPriceBetween(min, max);
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}
