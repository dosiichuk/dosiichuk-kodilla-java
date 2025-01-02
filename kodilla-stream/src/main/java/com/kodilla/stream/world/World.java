package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Set;

public class World {
    private Set<Continent> continents;

    public World(Set<Continent> continents) {
        this.continents = continents;
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
