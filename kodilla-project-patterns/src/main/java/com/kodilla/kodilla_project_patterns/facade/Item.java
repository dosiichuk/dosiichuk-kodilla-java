package com.kodilla.kodilla_project_patterns.facade;

public class Item {
    private final Long productId;
    private final double qty;
    public Item(Long productId, double qty) {
        this.productId = productId;
        this.qty = qty;
    }
    public Long getProductId() { return productId; }
    public double getQty() { return qty; }
}
