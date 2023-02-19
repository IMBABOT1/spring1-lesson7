package ru.geekbrains.spring1.lesson7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring1.lesson7.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
