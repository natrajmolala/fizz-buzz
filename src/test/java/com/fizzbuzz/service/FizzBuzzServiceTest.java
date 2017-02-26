package com.fizzbuzz.service;

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
        String result = service.call(21);

        assertThat(FIZZ, is(result));
    }

    @Test
    public void shouldNotReturnFizzWhenTheNumberNotDivisibleByThree() {
        String result = service.call(22);

        assertThat(FIZZ, not(result));
    }

    @Test
    public void shouldReturnBuzzWhenTheNumberDivisibleByFive() {
        String result = service.call(20);

        assertThat(BUZZ, is(result));
    }

    @Test
    public void shouldNotReturnBuzzWhenTheNumberNotDivisibleByFive() {
        String result = service.call(22);

        assertThat(BUZZ, not(result));
    }

    @Test
    public void shouldReturnFizzBuzzWhenTheNumberDivisibleByThreeAndFive() {
        String result = service.call(15);

        assertThat(FIZZ_BUZZ, is(result));
    }

    @Test
    public void shouldReturnInputAsStringWhenTheNumberNotDivisibleByThreeOrFive() {
        String result = service.call(77);

        assertThat(77 + "", is(result));
    }

}
