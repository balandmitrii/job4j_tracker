package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, представляющий банковский счет.
 */
public class Account {

    /**
     * Уникальный идентификатор счета (например, номер карты или IBAN).
     */
    private String requisite;

    /**
     * Баланс на счете.
     */
    private double balance;

    /**
     * Создает новый объект <code>Account</code>.
     *
     * @param requisite уникальный идентификатор счета
     * @param balance   начальный баланс счета
     */
    public Account(String requisite, double balance) {
        this.balance = balance;
        this.requisite = requisite;
    }

    /**
     * Возвращает уникальный идентификатор счета.
     *
     * @return уникальный идентификатор счета
     */

    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает новый уникальный идентификатор счета.
     *
     * @param requisite новый уникальный идентификатор счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает текущий баланс на счете.
     *
     * @return текущий баланс на счете
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает новый баланс на счете.
     *
     * @param balance новый баланс на счете
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает текущий объект с другим объектом для проверки их равенства.
     * Два объекта считаются равными, если у них одинаковые уникальные идентификаторы счетов.
     *
     * @param o объект для сравнения
     * @return true, если объекты равны, false в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает хэш-код объекта. Хэш-код используется в оптимизации некоторых операций.
     *
     * @return хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
