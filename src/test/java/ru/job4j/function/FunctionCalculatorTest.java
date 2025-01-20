package ru.job4j.function;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {
    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11.0D, 13.0D, 15.0D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 5, x -> x * x);
        List<Double> expected = Arrays.asList(4.0D, 9.0D, 16.0D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenExponentialFunctionThenExponentialResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(0, 3, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(1.0D, 2.0D, 4.0D);
        assertThat(result).containsAll(expected);
    }
}
