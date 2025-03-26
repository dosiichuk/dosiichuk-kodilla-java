package com.kodilla.kodilla_project_patterns.strategy;

import com.kodilla.kodilla_project_patterns.strategy.predictors.BuyPredictor;

public sealed class Customer permits  IndividualCustomer, IndividualYoungCustomer, CorporateCustomer {
    private final String name;
    protected BuyPredictor buyPredictor;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String predict() {
        return buyPredictor.predictWhatToBuy();
    }

    public void setBuyingStrategy(BuyPredictor buyPredictor) {
        this.buyPredictor = buyPredictor;
    }
}
