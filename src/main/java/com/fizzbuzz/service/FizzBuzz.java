package com.fizzbuzz.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = FIZZ + BUZZ;

    public String call(int input) {

        if (isDivisibleByThree(input) && isDivisibleByFive(input)) {
            return FIZZ_BUZZ;
        } else if (isDivisibleByThree(input)) {
            return FIZZ;
        } else if (isDivisibleByFive(input)) {
            return BUZZ;
        }

        return String.valueOf(input);
    }

    private boolean isDivisibleByFive(int input) {
        return input % 5 == 0;
    }

    private boolean isDivisibleByThree(int input) {
        return input % 3 == 0;
    }
}
