package com.kodilla.kodilla_project_patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private Pastry pastry;
    private Integer burgers;
    private String sauce;
    private List<String> ingredients;

    private Bigmac(Pastry pastry, Integer burgers, String sauce, List<String> ingredients) {
        this.pastry = pastry;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Pastry getPastry() {
        return pastry;
    }

    public Integer getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public static class BigmacBuilder {
        private Pastry pastry;
        private Integer burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder pastry(Pastry pastry) {
            this.pastry = pastry;
            return this;
        }

        public BigmacBuilder burgers(Integer burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if (this.pastry == null || this.burgers == null || this.ingredients.isEmpty()) {
                throw new IllegalStateException("Can't make a Bigmac without all components");
            }
            return new Bigmac(pastry, burgers, sauce, ingredients);
        }
    }
}
