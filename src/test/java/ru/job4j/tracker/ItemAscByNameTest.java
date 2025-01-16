package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void whenSortAscByNameSuccessfully() {
        List<Item> items = Arrays.asList(
                new Item("One", 1),
                new Item("Two", 2),
                new Item("Three", 3),
                new Item("Four", 4)
        );
        List<Item> expected = Arrays.asList(
                new Item("Four", 4),
                new Item("One", 1),
                new Item("Three", 3),
                new Item("Two", 2)
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenSortAscByNameFailure() {
        List<Item> items = Arrays.asList(
                new Item("One", 1),
                new Item("Two", 2),
                new Item("Three", 3),
                new Item("Four", 4)
        );
        List<Item> expected = Arrays.asList(
                new Item("One", 1),
                new Item("Three", 3),
                new Item("Four", 4),
                new Item("Two", 2)
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items).isNotEqualTo(expected);
    }
}