package com.kodilla.kodilla_hibernate.invoice.dao;

import com.kodilla.kodilla_hibernate.dao.InvoiceDao;
import com.kodilla.kodilla_hibernate.dao.ItemDao;
import com.kodilla.kodilla_hibernate.dao.ProductDao;
import com.kodilla.kodilla_hibernate.invoice.Invoice;
import com.kodilla.kodilla_hibernate.invoice.Item;
import com.kodilla.kodilla_hibernate.invoice.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Product1");
        Product product2 = new Product("Product2");
        Item item1 = new Item(new BigDecimal(100), 1, new BigDecimal(100));
        Item item2 = new Item(new BigDecimal(200), 1, new BigDecimal(200));
        Invoice invoice = new Invoice("123");
        item1.setProduct(product1);
        item2.setProduct(product2);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        assertNotEquals(0, id);

        //Cleanup
        try {
            invoiceDao.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
