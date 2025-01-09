package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявки ===");
        System.out.print("Введите ID заявки: ");
        int id = input.askInt("Введите ID заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("По ID=" + id + " найдена заявка: "
                    + item);
        } else {
            System.out.println("Заявка с введенным id: "
                    + id + " не найдена.");
        }
        return true;
    }
}
