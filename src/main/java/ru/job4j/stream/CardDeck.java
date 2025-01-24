package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardDeck {
    public static void main(String[] args) {
        List<Card> deck = Stream
                .of(Suit.values())
                .flatMap((Suit suit) ->
                        Stream
                                .of(Value.values())
                                .map(value -> new Card(value, suit)))
                .collect(Collectors.toList());
        System.out.println(deck);
    }
}
