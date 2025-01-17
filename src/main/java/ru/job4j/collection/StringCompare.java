package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0; i < left.length(); i++) {
            try {
                char charLeft = left.charAt(i);
                char charRight = right.charAt(i);
                int resultForChar = Integer.compare(charLeft, charRight);
                if (resultForChar < 0) {
                    result = -1;
                    break;
                } else if (resultForChar > 0) {
                    result = 1;
                    break;
                }
            } catch (Exception ex) {
                /*Если правое слово короче, то charRight вернет ошибку */
                result = 1;
            }
        }
        if (result == 0 && left.length() < right.length()) {
            result = -1;
        }
        return result;
    }
}
