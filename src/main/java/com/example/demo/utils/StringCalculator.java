package com.example.demo.utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class StringCalculator implements Predicate<Object> {


    @Override
    public boolean test(Object o) {
        return o.getClass() == String.class;
    }
}
