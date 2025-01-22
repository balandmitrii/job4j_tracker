package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public class CardDeck {
    public static void main(String[] args) {
        List deck = Stream.of(Suit.values())
                .flatMap(CardDeck::createCard)
                .toList();
        System.out.println(deck);
    }

    private static Stream createCard(Suit suit) {
        return Stream.of(Value.values())
                .map(value -> new Card(value, suit));
    }
}
