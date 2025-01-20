package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        BiConsumer<Integer, String> biConsumer = (k, v) -> map.put(k, v);
        biConsumer.accept(1, "one");
        biConsumer.accept(2, "two");
        biConsumer.accept(3, "three");
        biConsumer.accept(4, "four");
        biConsumer.accept(5, "five");
        biConsumer.accept(6, "six");
        biConsumer.accept(7, "seven");

        BiPredicate<Integer, String> biPredicate = (k, v) -> k % 2 == 0 || v.length() == 4;
        for (Integer key : map.keySet()) {
            if (biPredicate.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }

        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> strings = supplier.get();

        Consumer<String> consumer = System.out::println;
        Function<String, String> function = String::toUpperCase;

        for (String string : strings) {
            String upperCaseString = function.apply(string);
            consumer.accept(upperCaseString);
        }
    }
}
