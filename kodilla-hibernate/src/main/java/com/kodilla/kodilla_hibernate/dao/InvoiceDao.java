package com.kodilla.kodilla_hibernate.dao;

import com.kodilla.kodilla_hibernate.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceDao extends CrudRepository<Invoice, Integer> {
}
