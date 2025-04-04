package com.kodilla.kodilla_spring;

import com.kodilla.kodilla_spring.shape.Circle;
import com.kodilla.kodilla_spring.shape.Shape;
import com.kodilla.kodilla_spring.shape.Square;
import com.kodilla.kodilla_spring.shape.Triangle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class KodillaSpringApplicationTests {

	@Test
	void testCircleLoadedIntoContainer() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.kodilla_spring.shape");
		Shape shape = context.getBean(Circle.class);

		//When
		String name = shape.getShapeName();

		//Then
		assertEquals("This is a circle", name);
	}

	@Test
	void testTriangleLoadedIntoContainer() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.kodilla_spring.shape");
		Shape shape = context.getBean(Triangle.class);

		//When
		String name = shape.getShapeName();

		//Then
		assertEquals("This is a triangle.", name);
	}

//	@Test
//	void testSquareLoadedIntoContainer() {
//		//Given
//		ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.kodilla_spring.shape");
//		Shape shape = context.getBean(Square.class);
//		//When
//		String name = shape.getShapeName();
//		//Then
//		assertEquals("This is a square", name);
//	}

//	@Test
//	void testShapeLoadedIntoContainer() {
//		//Given
//		ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.kodilla_spring.shape");
//		Shape shape = (Shape)context.getBean("chosenShape");
//		//When
//		String name = shape.getShapeName();
//
//		//Then
//		System.out.println("Chosen shape says: " + name);
//
//	}

	@Test
	void contextLoads() {
	}


}
