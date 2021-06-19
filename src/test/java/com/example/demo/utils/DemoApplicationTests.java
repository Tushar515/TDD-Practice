package com.example.demo.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
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
	@DisplayName("AddUnknownAmountOfNumbers")
	void addUnknownAmountOfNumbers(){
		// Given
		String test = "1,2,3,4,5,6,7,8,9,10";
		// When
		int isValid = stringCalculator.Add(test);
		// Then
		assertThat(isValid).isEqualTo(55);
	}

	@Test
	@DisplayName("returnOnlySingleNumber")
	void returnOnlySingleNumber(){
		// Given
		String test = "1";
		// When
		int isValid = stringCalculator.Add(test);
		// Then
		assertThat(isValid).isEqualTo(1);
	}

	@Test
	@DisplayName("returnZero")
	void returnZero(){
		// Given
		String test = "";
		// When
		int isValid = stringCalculator.Add(test);
		// Then
		assertThat(isValid).isEqualTo(0);
	}

}
