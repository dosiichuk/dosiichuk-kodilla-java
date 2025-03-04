package com.kodilla.kodilla_spring;

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
				new AnnotationConfigApplicationContext("com.kodilla.kodilla_spring");
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
				new AnnotationConfigApplicationContext("com.kodilla.kodilla_spring");
		Shape shape = context.getBean(Triangle.class);

		//When
		String name = shape.getShapeName();

		//Then
		assertEquals("This is a triangle.", name);
	}

	@Test
	void contextLoads() {
	}


}
