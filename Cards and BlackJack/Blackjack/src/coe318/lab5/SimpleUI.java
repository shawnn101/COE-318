package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    @Override
    public void display() {
        System.out.println("    Your Cards:");
        for (Card card : game.getYourCards().getCards()) {
            System.out.println("        " + card);
        }

        System.out.println("    House's Cards:");
        for (int i = 0; i < game.getHouseCards().getCards().size(); i++) {
            Card card = game.getHouseCards().getCards().get(i);
            if (i == 0 && !card.isFaceUp()) {
                System.out.println("        [Face Down Card]");
            } else {
                System.out.println("        " + card);
            }
        }

        System.out.println("    Your Score: " + game.getPlayerScore());
        if (game.getHouseCards().getCards().get(0).isFaceUp()) {
            System.out.println("    House Score: " + game.getHouseScore());
        } else {
            System.out.println("    House has a face-down card.");
        }
    }

    @Override
    public boolean hitMe() {
        System.out.println("    Do you want another card? (y/n)");
        String response = user.nextLine();
        return response.equalsIgnoreCase("y");
    }

    @Override
    public void gameOver() {
        System.out.println("    Game Over!");
        display();
        if (game.getPlayerScore() > 21) {
            System.out.println("    You lose! Your score is over 21.");
        } else if (game.getHouseScore() > 21) {
            System.out.println("    You win! The house went over 21.");
        } else if (game.getPlayerScore() == game.getHouseScore()) {
            System.out.println("    It's a tie!");
        } else if (game.getPlayerScore() > game.getHouseScore()) {
            System.out.println("    You win!");
        } else {
            System.out.println("    You lose!");
        }
    }
}
