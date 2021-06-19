package com.example.demo.utils;

import org.springframework.stereotype.Service;

@Service
public class StringCalculator {

    public int Add(String numbers) {
        int add = 0;

        // Handle an empty string
        if(numbers.isEmpty())
            return 0;
        String[] splittedNumbers = numbers.split(",");

        // Handle only one number
        if(splittedNumbers.length == 1)
            return Integer.parseInt(splittedNumbers[0]);

        // Handle Unknown Amount of Numbers
        for(String s : splittedNumbers){
            add += Integer.parseInt(s);
        }

        return add;
    }
}
