

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {



        deck deck = new deck();
        Game game = new Game(deck);
        game.playGame();


        deck.shuffle();


        Player player1 = new Player();
        Player player2 = new Player();

        // Deal cards to players
        for (int i = 0; i < 4; i++) {
            player1.addCard(deck.dealCard(), i);
            player2.addCard(deck.dealCard(), i);
        }

        // Calculate player scores
        int player1Score = player1.calculateScore();
        int player2Score = player2.calculateScore();


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