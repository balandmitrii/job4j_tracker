package ru.job4j.stream;

import java.util.Objects;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return suit == card.suit && value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }
}
