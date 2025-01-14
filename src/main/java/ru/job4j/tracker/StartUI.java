package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker,
                     List<UserAction> userActions) {
        boolean run = true;
        while (run) {
            showMenu(userActions);
            int select = input.askInt("Выбрать: ");
            if (select < 0 || select >= userActions.size()) {
                output.println("Неверный ввод, вы можете выбрать: 0 .. " + (userActions.size() - 1));
                continue;
            }
            UserAction action = userActions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> userActions) {
        output.println("Меню:");
        for (int i = 0; i < userActions.size(); i++) {
            output.println(i + ". " + userActions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new CreateAction(output));
        userActions.add(new FindAllAction(output));
        userActions.add(new ReplaceAction(output));
        userActions.add(new DeleteAction(output));
        userActions.add(new FindByIdAction(output));
        userActions.add(new FindByNameAction(output));
        userActions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, userActions);
    }
}
