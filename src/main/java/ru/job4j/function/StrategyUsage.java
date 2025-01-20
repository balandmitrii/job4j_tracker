package ru.job4j.function;

import java.util.function.Function;
import java.util.function.Predicate;

public class StrategyUsage {

    public static void main(String[] args) {
        StrategyUsage usage = new StrategyUsage();
        System.out.println(
                "Результат работы: " + usage.check(
                        string -> string.isEmpty(), ""
                )
        );
        System.out.println(
                "Результат работы: " + usage.check(
                        string -> string.startsWith("Fun"), "Functional interface"
                )
        );
        System.out.println(
                "Результат работы: " + usage.check(
                        string -> string.contains("rn"), "Surname Name"
                )
        );
        System.out.println(
                "Строка после преобразования: " + usage.transform(
                        string -> string.toUpperCase(), "aBCdEfghKLmnpRstU"
                )
        );
        System.out.println(
                usage.transform(
                        string -> string.concat("работает корректно."), "Строка после преобразования: "
                )
        );
        System.out.println(
                "Строка после преобразования: " + usage.transform(
                        string -> string.trim(), "    aBC dEfghK Lmnp RstU        "
                )
        );
    }

    public boolean empty(String string) {
        return check(str -> str.isEmpty(), string);
    }

    public boolean startWith(String string, String prefix) {
        return check(str -> str.startsWith(prefix), string);
    }

    public boolean contains(String string, String key) {
        return check(str -> str.contains(key), string);
    }

    public boolean check(Predicate<String> predicate, String string) {
        return predicate.test(string);
    }

    public String transform(Function<String, String> function, String string) {
        return function.apply(string);
    }
}
