package com.example.demo.utils;

import org.springframework.stereotype.Service;

@Service
public class StringCalculator {

    public int Add(String numbers) {
        int add = 0;

        // Handle an empty string
        if (numbers.isEmpty())
            return 0;

        // Convert String into char[]
        char[] splittedNumbersInChar = numbers.toCharArray();

        // Check if given String have any custom delimiters
        if (splittedNumbersInChar[0] != '/') {

            String[] splittedNumbers = numbers.replaceAll("[\\n]", ",")
                    .split(",");

            // Handle only one number
            if (splittedNumbers.length == 1) {

                if (Integer.parseInt(splittedNumbers[0]) < 0)
                    throw new IllegalArgumentException("Negative values not allowed "+numbers);

                if(Integer.parseInt(splittedNumbers[0]) > 999)
                    return 0;
                
                return Integer.parseInt(splittedNumbers[0]);
            }

            // Handle Unknown Amount of Numbers
            for (String s : splittedNumbers) {
                if (Integer.parseInt(s) < 0)
                    throw new IllegalArgumentException("Negative values not allowed "+numbers);

                if(Integer.parseInt(s)>999)
                    continue;

                add += Integer.parseInt(s);
            }

            return add;
        }

        for (char c : splittedNumbersInChar) {
            if (c >= 48 && c <= 57)
                add += Character.getNumericValue(c);
        }
        return add;
    }
}
