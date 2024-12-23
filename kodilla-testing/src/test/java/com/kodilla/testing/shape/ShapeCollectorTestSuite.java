package com.kodilla.testing.shape;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Test for adding a shape")
    class TestAddShape {
        @Test
        @DisplayName("Test for adding a circle")
        void testAddCircle() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("Circle", 10);
            // When
            shapeCollector.addFigure(circle);
            // Then
            assertEquals(1, shapeCollector.shapes.size());
        }

        @Test
        @DisplayName("Test for adding a square")
        void testAddSquare() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("Square", 10);
            // When
            shapeCollector.addFigure(square);
            // Then
            assertEquals(1, shapeCollector.shapes.size());
        }
    }

    @Nested
    @DisplayName("Test for removing a shape")
    class TestRemoveShape {
        @Test
        @DisplayName("Test for removing a circle")
        void testRemoveCircle() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("Circle", 10);
            shapeCollector.addFigure(circle);
            // When
            boolean result = shapeCollector.removeFigure(circle);
            // Then
            assertTrue(result);
            assertEquals(0, shapeCollector.shapes.size());
        }

        @Test
        @DisplayName("Test for removing a square")
        void testRemoveSquare() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("Square", 10);
            shapeCollector.addFigure(square);
            // When
            boolean result = shapeCollector.removeFigure(square);
            // Then
            assertTrue(result);
            assertEquals(0, shapeCollector.shapes.size());
        }
    }

    @Nested
    @DisplayName("Test for getting a shape")
    class TestGetShape {
        @Test
        @DisplayName("Test for getting a circle")
        void testGetCircle() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("Circle", 10);
            shapeCollector.addFigure(circle);
            // When
            Shape retrievedShape = shapeCollector.getFigure(0);
            // Then
            assertEquals(circle, retrievedShape);
        }

        @Test
        @DisplayName("Test for getting a square")
        void testGetSquare() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("Square", 10);
            shapeCollector.addFigure(square);
            // When
            Shape retrievedShape = shapeCollector.getFigure(0);
            // Then
            assertEquals(square, retrievedShape);
        }
    }

    @Nested
    @DisplayName("Test for showing shapes")
    class TestShowShapes {
        @Test
        @DisplayName("Test for showing shapes")
        void testShowShapes() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("Circle", 10);
            Square square = new Square("Square", 10);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            // When
            String result = shapeCollector.showFigures();
            // Then
            assertEquals("Circle, Square", result);
        }
    }

}
