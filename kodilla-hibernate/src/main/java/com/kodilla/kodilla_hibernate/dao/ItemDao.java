package com.kodilla.kodilla_hibernate.dao;

import com.kodilla.kodilla_hibernate.invoice.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDao extends CrudRepository<Item, Integer> {
}
