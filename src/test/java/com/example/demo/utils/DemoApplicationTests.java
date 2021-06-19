package com.example.demo.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
class DemoApplicationTests {
	StringCalculator stringCalculator;

	@BeforeEach
	void setUp() {
		stringCalculator = new StringCalculator();
	}

	@Test
	@DisplayName("Ignore An Value More Than 1000")
	void ignoreAnValueMoreThan1000(){
		// Given
		String str = "2000";
		// When
		int isValid = stringCalculator.Add(str);
		// Then
		assertThat(isValid).isEqualTo(0);
	}

	@Test
	@DisplayName("Ignore Values More Than 1000")
	void ignoreValueMoreThan1000(){
		// Given
		String str = "1,2000,1111,7";
		// When
		int isValid = stringCalculator.Add(str);
		// Then
		assertThat(isValid).isEqualTo(8);
	}

	@Test
	@DisplayName("Test Multiple Negative Values")
	void testMultipleNegativeValues(){
		// Given
		String str = "-1,-2,-3";

		try {
			stringCalculator.Add(str);
			fail("Should throw an exception if one or more values are negative");
		}
		catch (Exception e){
			assertThat(e).isInstanceOf(IllegalArgumentException.class)
					.hasMessage("Negative values not allowed "+str);
		}

	}

	@Test
	@DisplayName("Negative Numbers Exception Testing")
	void testException(){
		// Given
		String str = "-1";

		try {
			stringCalculator.Add(str);
			fail("Should throw an exception if one or more values are negative");
		}
		catch (Exception e){
			assertThat(e).isInstanceOf(IllegalArgumentException.class)
					.hasMessage("Negative values not allowed "+str);
		}
	}

	@Test
	@DisplayName("SupportDifferentDelimiters")
	void supportDifferentDelimiters(){
		// Given
		String test = "//;\n1;2";
		// When
		int isValid = stringCalculator.Add(test);
		// Then
		assertThat(isValid).isEqualTo(3);
	}

	@Test
	@DisplayName("RemoveDelimiters")
	void removeDelimiters(){
		// Given
		String test = "1\n2,3";
		// When
		int isValid = stringCalculator.Add(test);
		// Then
		assertThat(isValid).isEqualTo(6);
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
