package com.kodilla.kodilla_project_patterns.decorator.taxiportal;

import java.math.BigDecimal;

public class VipCarDecorator extends AbstractTaxiOrderDecorator {
    public VipCarDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }


    @Override
    public String getDescription() {
        return super.getDescription() + " variant VIP";
    }
}
