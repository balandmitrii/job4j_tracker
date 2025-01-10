package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class FindByIdAction implements UserAction {
    private final Output output;

    public FindByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод заявки ===");
        output.println("Введите ID заявки: ");
        int id = input.askInt("Введите ID заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.println("По ID=" + id + " найдена заявка: "
                    + item);
        } else {
            output.println("Заявка с введенным id: "
                    + id + " не найдена.");
        }
        return true;
    }
}
