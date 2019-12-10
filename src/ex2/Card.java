package ex2;

import java.util.Random;

public class Card implements Comparable<Card> {
    int value;
    String naipe;
    String figure;
    static String[] naipes = new String[] { "Clubs", "Hearts", "Spades", "Diamonds" };
    static String[] figures = new String[] { "Queen", "Jack", "King" };

    public Card(int value, String figure, String naipe) {
        this.value = value;
        this.figure = figure;
        this.naipe = naipe;
    }

    static int getValue(Card c) {
        if (c.figure.equals("Jack")) {
            return 11;
        } else if (c.figure.equals("Queen")) {
            return 12;
        } else if (c.figure.equals("King")) {
            return 13;
        } else {
            return c.value;
        }
    }

    static Card cardGenerator() {
        int naipe = new Random().nextInt(4);
        int value = new Random().nextInt(13) + 1;

        if (value > 10) {
            return new Card(value, figures[(value-1) % 10], naipes[naipe]);
        } else {
            return new Card(value,"", naipes[naipe]);
        }
    }

    @Override
    public String toString() {
        if (this.value > 10) {
            return this.figure + " " + this.naipe;
        }
        return this.value + " " + this.naipe;
    }

    @Override
    public int compareTo(Card o) {
        if (Card.getValue(this) > Card.getValue(o)) {
            return -1;
        } else if (Card.getValue(this) < Card.getValue(o)) {
            return 1;
        } else {
            return 0;
        }
    }
}