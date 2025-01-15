package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("balandmitry.webdev@gmail.com", "Balan Dmitriy Petrovich");
        hashMap.put("ChuckNorris@gmail.com", "Chuck Norris");
        hashMap.put("BruceLee@gmail.com", "Bruce Lee");
        hashMap.put("balandmitry.webdev@gmail.com", "Balan Dmitriy");
        hashMap.put("ChuckNorris@gmail.com", "Norris Chuck");
        for (Map.Entry<String, String> item : hashMap.entrySet()) {
            System.out.println("Email: " + item.getKey() + ", name: " + item.getValue());
        }
    }
}
