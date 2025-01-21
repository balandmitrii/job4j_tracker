package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map((Profile profile) -> {
                    Address address = profile.getAddress();
                    return new Address(
                            address.getCity(),
                            address.getStreet(),
                            address.getHome(),
                            address.getApartment()
                    );
                })
                .toList();
    }
}