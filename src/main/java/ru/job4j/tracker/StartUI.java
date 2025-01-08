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
            System.out.print("Выбрать: ");
            System.out.println();
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 1) {
                System.out.println("=== Создание новой заявки ===");
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 2) {
                System.out.println("=== Вывод всех заявок ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 3) {
                System.out.println("=== Замена заявки ===");
                System.out.print("Введите ID заявки: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка изменена успешно!");
                } else {
                    System.out.println("Ошибка замены заявки");
                }
            } else if (select == 4) {
                System.out.println("=== Удаление заявки ===");
                System.out.print("Введите ID заявки: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена успешно!");
                } else {
                    System.out.println("Не удалось удалить заявку с id: " + id);
                }
            } else if (select == 5) {
                System.out.println("=== Вывод заявки ===");
                System.out.print("Введите ID заявки: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("По ID=" + id + " найдена заявка: "
                            + item);
                } else {
                    System.out.println("Заявка с введенным id: "
                            + id + " не найдена.");
                }
            } else if (select == 6) {
                System.out.println("=== Вывод заявок по имени ===");
                System.out.print("Введите имя заявки: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с именем: " + name
                            + " не найдены.");
                }
            } else if (select == menu.length) {
                System.out.println();
                System.out.println("Программа завершена.");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println();
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
