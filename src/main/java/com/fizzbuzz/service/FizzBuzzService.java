package com.fizzbuzz.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = "FizzBuzz";

    public String call(int input) {
        if (input % 3 == 0 && input % 5 == 0) {
            return FIZZ_BUZZ;
        } else if (input % 3 == 0) {
            return FIZZ;
        } else if (input % 5 == 0) {
            return BUZZ;
        }

        return String.valueOf(input);
    }
}
