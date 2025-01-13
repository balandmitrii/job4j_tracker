package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] outer : list) {
            for (int inner : outer) {
                result.add(inner);
            }
        }
        return result;
    }
}