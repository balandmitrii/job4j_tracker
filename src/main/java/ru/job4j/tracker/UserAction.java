package ru.job4j.tracker;

public interface UserAction {
    public String name();

    boolean execute(Input input, Tracker tracker);
}
