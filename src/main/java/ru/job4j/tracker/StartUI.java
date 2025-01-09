package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] userActions) {
        boolean run = true;
        while (run) {
            showMenu(userActions);
            int select = input.askInt("Выбрать: ");
            UserAction action = userActions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] userActions) {
        System.out.println();
        for (int i = 0; i < userActions.length; i++) {
            System.out.println(i + ". " + userActions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] userActions = {
                new CreateAction(),
                new FindAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, userActions);
    }
}
