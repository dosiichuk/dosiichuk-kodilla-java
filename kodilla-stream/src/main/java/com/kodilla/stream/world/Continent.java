package com.kodilla.stream.world;

import java.util.Set;

public class Continent {
    private final Set<Country> countries;

    public Continent(Set<Country> countries) {
        this.countries = countries;
    }

    public Set<Country> getCountries() {
        return countries;
    }
}
