package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        Function<Profile, Address> address =
                (Profile profile) -> profile.getAddress();
        return profiles.stream()
                .map(address)
                .map(Profiles::createAddress)
                .toList();
    }

    private static Address createAddress(Address address) {
        return new Address(
                address.getCity(),
                address.getStreet(),
                address.getHome(),
                address.getApartment()
        );
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