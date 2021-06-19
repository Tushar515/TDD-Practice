package com.example.demo.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	StringCalculator stringCalculator;

	@BeforeEach
	void setUp() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void Add(){
		// Given
		String test = "Demo";
		// When
		boolean isValid = stringCalculator.test(test);
		// Then
		assertThat(isValid).isEqualTo(true);
	}

}