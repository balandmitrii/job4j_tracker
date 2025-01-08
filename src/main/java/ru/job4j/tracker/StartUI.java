package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    private final String[] menu = {"Добавить новую заявку",
            "Показать все заявки",
            "Изменить заявку", "Удалить заявку",
            "Показать заявку по id", "Показать заявки по имени",
            "Завершить программу"};

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.println("Выбрать");
            int select = Integer.parseInt(scanner.nextLine());
            if (select != menu.length) {
                System.out.println("Польователь выбрал: " + select);
            } else {
                System.out.println("Программа завершена.");
                run = false;
            }
        }
    }

    private void showMenu() {
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
