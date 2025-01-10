package ru.job4j.tracker.action;

import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class DeleteAction implements UserAction {
    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Удаление заявки ===");
        int id = input.askInt("Введите ID заявки: ");
        if (tracker.delete(id)) {
            output.println("Заявка удалена успешно!");
        } else {
            output.println("Не удалось удалить заявку с id: " + id);
        }
        return true;
    }
}
