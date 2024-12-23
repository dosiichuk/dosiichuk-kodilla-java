package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShapeCollector {

    List<Shape> shapes = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if (shapes.isEmpty() || shape == null || !shapes.contains(shape)) {
            return false;
        }
        shapes.remove(shape);
        return true;

    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        }
        return null;
    }

    public String showFigures() {
        return String.join(", ", shapes.stream().map(Shape::getShapeName).toArray(String[]::new));
    }
}
