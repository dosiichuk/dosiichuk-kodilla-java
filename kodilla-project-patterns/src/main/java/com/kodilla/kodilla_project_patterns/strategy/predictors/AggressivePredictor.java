package com.kodilla.kodilla_project_patterns.strategy.predictors;

public final class AggressivePredictor implements BuyPredictor {

    @Override
    public String predictWhatToBuy() {
        return "[Aggressive predictor] Buy stock of XYZ";
    }
}
