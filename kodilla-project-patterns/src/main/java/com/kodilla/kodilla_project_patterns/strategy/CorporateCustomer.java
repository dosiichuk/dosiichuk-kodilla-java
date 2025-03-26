package com.kodilla.kodilla_project_patterns.strategy;

import com.kodilla.kodilla_project_patterns.strategy.predictors.BalancedPredictor;

public final class CorporateCustomer extends Customer {

    public CorporateCustomer(String name) {
        super(name);
        this.buyPredictor = new BalancedPredictor();
    }
}
