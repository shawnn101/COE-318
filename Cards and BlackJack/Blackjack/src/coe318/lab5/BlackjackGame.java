package coe318.lab5;

public class BlackjackGame {

    private CardPile deck;
    private CardPile houseCards;
    private CardPile yourCards;
    private boolean houseDone;
    private boolean playerDone;
    private UserInterface ui;

    public BlackjackGame(UserInterface ui) {
        this.ui = ui;
        ui.setGame(this);
        deck = new CardPile();
        for (int i = 2; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        houseCards = new CardPile();
        yourCards = new CardPile();
        houseDone = false;
        playerDone = false;
    }

    public void start() {
        Card c;
        // Add one face-down and one face-up card to the house
        c = deck.removeRandom();
        c.setFaceUp(false);
        getHouseCards().add(c);
        getHouseCards().add(deck.removeRandom());

        // Add two face-up cards to the player
        getYourCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        ui.display();
    }

    public void play() {
        while (!houseDone || !playerDone) {
            if (!houseDone) {
                if (score(getHouseCards()) < 17) {
                    getHouseCards().add(deck.removeRandom());
                    System.out.println("    House draws a card.");
                    ui.display();
                    // Check if house goes over 21
                    if (score(getHouseCards()) > 21) {
                        System.out.println("    House score went over 21!");
                        houseDone = true;
                        playerDone = true; // Force end of game
                        break; // Exit the loop to end the game
                    }
                } else {
                    houseDone = true;
                }
            }
            if (!playerDone) {
                if (ui.hitMe()) {
                    getYourCards().add(deck.removeRandom());
                    System.out.println("    You draw a card.");
                    ui.display();
                    // Check if player goes over 21
                    if (score(getYourCards()) > 21) {
                        System.out.println("    Your score went over 21!");
                        houseDone = true; // Force end of game
                        playerDone = true;
                        break; // Exit the loop to end the game
                    }
                } else {
                    playerDone = true;
                }
            }
        }
        end(); // Call end() after breaking out of the loop
    }

    public void end() {
        // Reveal the house's first card (face-down card)
        getHouseCards().getCards().get(0).setFaceUp(true);
        ui.gameOver();
    }

    /**
     * Determine the score of a pile of cards.
     *
     * @param p the card pile
     * @return the score
     */
    public int score(CardPile p) {
        int totalScore = 0;
        for (Card card : p.getCards()) {
            int rank = card.getRank();
            if (rank >= 11 && rank <= 13) {
                totalScore += 10; // Jack, Queen, King are worth 10 points
            } else if (rank == 14) {
                totalScore += 1;  // Ace is worth 1 point in this simplified game
            } else {
                totalScore += rank; // Numbered cards are worth their rank
            }
        }
        return totalScore;
    }

    /**
     * @return the houseCards
     */
    public CardPile getHouseCards() {
        return houseCards;
    }

    /**
     * @return the yourCards
     */
    public CardPile getYourCards() {
        return yourCards;
    }

    public int getPlayerScore() {
        return score(yourCards);
    }

    public int getHouseScore() {
        return score(houseCards);
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame(new SimpleUI());
        game.start();
        game.play();
        game.end();
    }
}
