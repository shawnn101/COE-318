package coe318.lab5;

import java.util.ArrayList;
import java.util.Random;

public class CardPile {
  private ArrayList<Card> cards;

  public CardPile() {
    cards = new ArrayList<>();
  }

  public void add(Card card) {
    cards.add(card);
  }

  public Card removeRandom() {
    if (cards.isEmpty()) {
      return null;
    }
    Random rand = new Random();
    return cards.remove(rand.nextInt(cards.size()));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Card card : cards) {
      sb.append(card).append(" ");
    }
    return sb.toString().trim();
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  public static void main(String[] args) {
    CardPile p = new CardPile();
    p.add(new Card(2, Card.DIAMOND, true));
    p.add(new Card(3, Card.HEART, true));
    p.add(new Card(4, Card.SPADE, false));
    p.add(new Card(14, Card.DIAMOND, true));
    System.out.println("Removed: " + p.removeRandom());
    System.out.println("Removed: " + p.removeRandom());
    System.out.println("Removed: " + p.removeRandom());
    System.out.println("Removed: " + p.removeRandom());

    CardPile deck = new CardPile();
    for (int i = 2; i < 15; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(new Card(i, j, true));
      }
    }
    for (int i = 0; i < 52; i++) {
      System.out.println((i + 1) + ": " + deck.removeRandom());
    }
  }
}
