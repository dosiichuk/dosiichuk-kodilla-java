package com.kodilla.kodilla_project_patterns.strategy.predictors;

public sealed interface BuyPredictor permits AggressivePredictor, ConservativePredictor, BalancedPredictor {
    String predictWhatToBuy();
}
