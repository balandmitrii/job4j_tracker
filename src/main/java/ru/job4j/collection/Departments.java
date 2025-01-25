package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
            Set<String> temp = new LinkedHashSet<>();
            for (String value : departments) {
                String start = "";
                for (String element : value.split("/")) {
                    if (!start.isEmpty()) {
                        start += "/";
                    }
                    start += element;
                    temp.add(start);
                }
            }
            return temp.stream()
                    .sorted()
                    .toList();
    }

    public static void sortAsc(List<String> departments) {
        fillGaps(departments);
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        fillGaps(departments);
        departments.sort(new DepartmentsDescComparator());
    }
}