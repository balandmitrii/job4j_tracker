package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.add(index, item);
        }
        return result;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
            size--;
        }
        return result;
    }

    public int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (items.get(i).getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int sizeResult = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items.get(i).getName())) {
                result[sizeResult++] = items.get(i);
            }
        }
        return Arrays.copyOf(result, sizeResult);
    }
}