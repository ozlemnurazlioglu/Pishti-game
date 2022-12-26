import Player.Game;
import Player.Player;
import Player.deck;

public class Main {
    public static void main(String[] args) {
        deck deck = new deck();  // Change the name of the variable or the type
        Game game = new Game(deck);
        game.playGame();




        deck.shuffle();

        Player player = new Player();
        Player computer = new Player();

        // Deal cards to players
        for (int i = 0; i < 4; i++) {
            player.addCard(deck.dealCard(), i);
            computer.addCard(deck.dealCard(), i);
        }



        System.out.println("Shuffled deck:");
        for (String card : deck.getCards()) {
            System.out.println(card);
        }

        deck.cut();

        System.out.println("\nCut deck:");
        for (String card : deck.getCards()) {
            System.out.println(card);
        }

        String[][] hands = deck.dealCards();
        System.out.println("\nHands:");
        for (String[] hand : hands) {
            for (String card : hand) {
                System.out.println(card);
            }
            System.out.println();
        }
    }
}
