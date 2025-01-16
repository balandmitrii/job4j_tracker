package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    void whenSortDescByNameSuccessfully() {
        List<Item> items = Arrays.asList(
                new Item("One", 1),
                new Item("Two", 2),
                new Item("Three", 3),
                new Item("Four", 4)
        );
        List<Item> expected = Arrays.asList(
                new Item("Two", 2),
                new Item("Three", 3),
                new Item("One", 1),
                new Item("Four", 4)
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenSortDescByNameFailure() {
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
        Collections.sort(items, new ItemDescByName());
        assertThat(items).isNotEqualTo(expected);
    }
}