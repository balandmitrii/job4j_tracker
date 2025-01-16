package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 3, 6, 2, 0, 1, 10);
        System.out.println(list);
        list.sort(Collections.reverseOrder());
        System.out.println(list);
    }
}
