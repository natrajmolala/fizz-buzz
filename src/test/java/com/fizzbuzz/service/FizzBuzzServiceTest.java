package com.fizzbuzz.service;

import org.hamcrest.Matcher;
import org.junit.Test;

import static com.fizzbuzz.service.FizzBuzzService.BUZZ;
import static com.fizzbuzz.service.FizzBuzzService.FIZZ;
import static com.fizzbuzz.service.FizzBuzzService.FIZZ_BUZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class FizzBuzzServiceTest {

    private FizzBuzzService service = new FizzBuzzService();

    @Test
    public void shouldReturnFizzWhenTheNumberDivisibleByThree() {
        verifyResult(21, is(FIZZ));
    }

    @Test
    public void shouldNotReturnFizzWhenTheNumberNotDivisibleByThree() {
        verifyResult(22, not(FIZZ));
    }

    @Test
    public void shouldReturnBuzzWhenTheNumberDivisibleByFive() {
        verifyResult(20, is(BUZZ));
    }

    @Test
    public void shouldNotReturnBuzzWhenTheNumberNotDivisibleByFive() {
        verifyResult(22, not(BUZZ));
    }

    @Test
    public void shouldReturnFizzBuzzWhenTheNumberDivisibleByThreeAndFive() {
        verifyResult(15, is(FIZZ_BUZZ));
    }

    @Test
    public void shouldReturnInputAsStringWhenTheNumberNotDivisibleByThreeOrFive() {
        verifyResult(77, is(String.valueOf(77)));
    }

    private void verifyResult(int number, Matcher<String> matcher) {
        assertThat(service.call(number), matcher);
    }

}
