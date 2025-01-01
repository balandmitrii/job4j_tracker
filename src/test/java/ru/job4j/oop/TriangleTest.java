package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {
    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 8;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when33and77and1212ThenMinus1() {
        Point a = new Point(3, 3);
        Point b = new Point(7, 7);
        Point c = new Point(12, 12);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1.0;
        assertThat(result).isEqualTo(expected);
    }
}
