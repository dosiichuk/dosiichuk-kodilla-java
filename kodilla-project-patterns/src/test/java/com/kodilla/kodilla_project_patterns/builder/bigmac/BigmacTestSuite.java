package com.kodilla.kodilla_project_patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac
                .BigmacBuilder()
                .pastry(Pastry.BUN)
                .burgers(2)
                .sauce("1000 spices")
                .ingredient("bacon").build();
        //When
        Integer numIngredients = bigmac.getIngredients().size();
        String sauce = bigmac.getSauce();

        //Then
        assertEquals(1, numIngredients);
        assertEquals("1000 spices", sauce);
    }

    @Test
    void testBigmacBuilderThrowsIllegalStateError() {
        //When
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> new Bigmac.BigmacBuilder()
                .pastry(Pastry.BUN)
                .sauce("1000 spices")
                .ingredient("bacon").build());


        //Then
        assertEquals("Can't make a Bigmac without all components", exception.getMessage());
    }
}
