package ru.job4j.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    @DisplayName("Если ничего не найдено")
    void whenFindNothing() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Ivan");
        assertThat(persons).isEmpty();
    }

    @Test
    @DisplayName("Когда найдено несколько совпадений")
    void whenFindTwoItems() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Ivanov", "345621", "Tula")
        );
        phones.add(
                new Person("Artem", "Stoikov", "348322", "Ufa")
        );
        ArrayList<Person> persons = phones.find("348");
        assertThat(persons.size()).isEqualTo(2);
    }
}