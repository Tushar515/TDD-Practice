package com.example.demo.utils;

import org.springframework.stereotype.Service;

@Service
public class StringCalculator {

    public int Add(String numbers) {

        if(numbers.isEmpty())
            return 0;
        String[] splittedNumbers = numbers.split(",");

        if(splittedNumbers.length == 1)
            return Integer.parseInt(splittedNumbers[0]);

        return Integer.parseInt(splittedNumbers[0]) +
                Integer.parseInt(splittedNumbers[1]);
    }
}
