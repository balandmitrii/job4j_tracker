package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс BankService управляет банковской системой, где пользователи могут иметь несколько счетов.
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в банк, если он еще не существует.
     *
     * @param user Объект User для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из банка по номеру паспорта.
     *
     * @param passport Номер паспорта пользователя, которого нужно удалить
     */
    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    /**
     * Добавляет счет пользователю по номеру паспорта.
     *
     * @param passport Номер паспорта пользователя
     * @param account Объект Account для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит пользователя по номеру паспорта.
     *
     * @param passport Номер паспорта пользователя
     * @return Объект User, если найден, иначе null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Находит счет по номеру паспорта и реквизитам.
     *
     * @param passport Номер паспорта пользователя
     * @param requisite Реквизиты счета
     * @return Объект Account, если найден, иначе null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        for (Account account : users.get(user)) {
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }
        return null;
    }

    /**
     * Переводит деньги с одного счета на другой.
     *
     * @param sourcePassport Номер паспорта источника пользователя
     * @param sourceRequisite Реквизиты исходного счета
     * @param destinationPassport Номер паспорта получателя пользователя
     * @param destinationRequisite Реквизиты целевого счета
     * @param amount Сумма перевода
     * @return true, если перевод успешен, иначе false
     */
    public boolean transferMoney(String sourcePassport,
                                 String sourceRequisite,
                                 String destinationPassport,
                                 String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        if (sourceAccount == null || sourceAccount.getBalance() < amount) {
            return false;
        }
        Account destinationAccount = findByRequisite(destinationPassport,
                destinationRequisite);
        if (destinationAccount == null) {
            return false;
        }
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        return true;
    }

    /**
     * Получает список счетов для конкретного пользователя.
     *
     * @param user Объект User
     * @return Список, содержащий счета пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
