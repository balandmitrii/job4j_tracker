package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс User представляет пользователя с паспортом и именем.
 */
public class User {
    private String passport;
    private String username;

    /**
     * Конструктор для создания нового объекта User с указанным паспортом и именем.
     *
     * @param passport Номер паспорта пользователя
     * @param username Имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает имя пользователя.
     *
     * @return Имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает новое имя пользователя.
     *
     * @param username Новое имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Возвращает номер паспорта пользователя.
     *
     * @return Номер паспорта пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает новый номер паспорта пользователя.
     *
     * @param passport Новый номер паспорта пользователя
     */
    public void setPasspord(String passport) {
        this.passport = passport;
    }

    /**
     * Сравнивает текущий объект User с другим объектом на равенство.
     *
     * @param o Объект для сравнения
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хеш-код объекта User.
     *
     * @return Хеш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(passport);
    }
}
