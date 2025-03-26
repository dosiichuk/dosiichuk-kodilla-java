package com.kodilla.kodilla_project_patterns.strategy;

import com.kodilla.kodilla_project_patterns.strategy.predictors.AggressivePredictor;

 final class IndividualYoungCustomer extends Customer {

    public IndividualYoungCustomer(String name) {
        super(name);
        this.buyPredictor = new AggressivePredictor();
    }
}
