package coe318.lab5;

public class Card implements Comparable<Card> {
  // Symbolic constants
  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  private final int rank;  // Rank of the card
  private final int suit;  // Suit of the card
  private boolean faceUp;  // If the card is face up

  public Card(int rank, int suit, boolean faceUp) {
    this.rank = rank;
    this.suit = suit;
    this.faceUp = faceUp;
  }

  public boolean isFaceUp() {
    return this.faceUp;
  }

  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }

  public int getRank() {
    return this.rank;
  }

  public int getSuit() {
    return this.suit;
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    return this.rank == c.rank && this.suit == c.suit;
  }

  @Override
  public int compareTo(Card c) {
    return Integer.compare(this.rank, c.rank);
  }

  public String getRankString() {
    switch (rank) {
      case 11: return "Jack";
      case 12: return "Queen";
      case 13: return "King";
      case 14: return "Ace";
      default: return Integer.toString(rank);
    }
  }

  public String getSuitString() {
    switch (suit) {
      case CLUB: return "Clubs";
      case DIAMOND: return "Diamonds";
      case HEART: return "Hearts";
      case SPADE: return "Spades";
      default: return "";
    }
  }

  @Override
  public String toString() {
    if (!faceUp) {
      return "?";
    }
    return getRankString() + " of " + getSuitString();
  }

  public static void main(String[] args) {
    Card club5 = new Card(5, CLUB, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: " + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: " + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: " + club5.equals(spadeAce));
    System.out.println("club5 equals club5: " + club5.equals(club5));
  }
}
