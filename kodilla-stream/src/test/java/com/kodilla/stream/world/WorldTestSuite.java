package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Continent continent1 = new Continent(Set.of(new Country(new BigDecimal("120")), new Country(new BigDecimal("200"))));
        Continent continent2 = new Continent(Set.of(new Country(new BigDecimal("110")), new Country(new BigDecimal("5"))));
        Continent continent3 = new Continent(Set.of(new Country(new BigDecimal("10")), new Country(new BigDecimal("20"))));
        World world = new World(Set.of(continent1, continent2, continent3));

        //When
        BigDecimal peopleQuantity = world.getPeopleQuantity();

        //Then
        assertEquals(new BigDecimal(465), peopleQuantity);
    }
}
