package com.kodilla.kodilla_project_patterns.strategy;

import com.kodilla.kodilla_project_patterns.strategy.predictors.ConservativePredictor;

public final class IndividualCustomer extends Customer {

    public IndividualCustomer(String name) {
        super(name);
        this.buyPredictor = new ConservativePredictor();
    }
}
