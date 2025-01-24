package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map((Profile profile) -> profile.getAddress())
                .collect(Collectors.toList());
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        Function<Profile, Address> address =
                (Profile profile) -> profile.getAddress();
        return profiles.stream()
                .map(address)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .toList();
    }
}