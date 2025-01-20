package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Класс PhoneDictionary предназначен для поиска людей в списке по различным критериям.
 */
public class PhoneDictionary {

    /**
     * Список, содержащий объекты типа Person.
     */
    private final ArrayList<Person> persons = new ArrayList<>();

    /**
     * Добавляет нового человека в словарь.
     *
     * @param person Объект типа Person для добавления.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Выполняет поиск людей по заданному ключу. Поиск осуществляется по имени, фамилии, номеру телефона и адресу.
     *
     * @param key Ключевое слово для поиска в информации о людях.
     * @return Список объектов типа Person, соответствующих критериям поиска.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> byPhone = (person) -> person.getPhone().contains(key);
        Predicate<Person> byAddress =
                (person) -> person.getAddress().contains(key);
        Predicate<Person> byName =
                (person) -> person.getName().contains(key);
        Predicate<Person> bySurname =
                (person) -> person.getSurname().contains(key);

        Predicate<Person> combine =
                byPhone.or(byAddress).or(byName).or(bySurname);

        ArrayList<Person> result = new ArrayList<>();

        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }

        return result;
    }
}
