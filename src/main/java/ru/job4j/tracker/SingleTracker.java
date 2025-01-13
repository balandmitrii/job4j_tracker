package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {
    private static final SingleTracker INSTANCE = new SingleTracker();
    private final Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public int indexOf(int id) {
        return tracker.indexOf(id);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }
}
