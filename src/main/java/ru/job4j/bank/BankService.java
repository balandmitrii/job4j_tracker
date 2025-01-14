package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        List<Account> userAccounts = users.get(user);
        if (!userAccounts.contains(account)) {
            userAccounts.add(account);
            users.replace(user, userAccounts);
        }
    }

    public User findByPassport(String passport) {
        User foundUser = null;
        for (Map.Entry<User, List<Account>> user : users.entrySet()) {
            if (user.getKey().getPassport() == passport) {
                return user.getKey();
            }
        }
        return foundUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        Account foundAccount = null;
        for (Account account : users.get(user)) {
            if (account.getRequisite().equals(requisite)) {
                foundAccount = account;
            }
        }
        return foundAccount;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
