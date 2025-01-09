package ru.job4j.tracker;

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
