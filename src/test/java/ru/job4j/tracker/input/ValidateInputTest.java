package ru.job4j.tracker.input;
import ru.job4j.tracker.output.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenInputSuccessfully() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");;
        System.out.println(selected);
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenInputFewNumbers() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected1 = input.askInt("Enter menu:");
        int selected2 = input.askInt("Enter menu:");
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(1);
        assertThat(selected2).isEqualTo(2);
        assertThat(selected3).isEqualTo(3);
    }

    @Test
    void whenInputNegativeNumber() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        System.out.println(selected);
        assertThat(selected).isEqualTo(-3);
    }
}