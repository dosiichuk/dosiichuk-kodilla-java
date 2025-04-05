package com.kodilla.kodilla_hibernate.dao;

import com.kodilla.kodilla_hibernate.invoice.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}
