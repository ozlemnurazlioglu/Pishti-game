import Player.Player;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

package Player;




import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private Player[] players;
    private String[] board;
    private deck deck;


    public Game(deck deck) {
        this.deck = deck;
        this.players = new Player[2];
        this.players[0] = new Player();
        this.players[1] = new Player();
        this.board = new String[4];
    }

    public void playGame() {
        deck.cut();
        dealCards();
        dealBoard();
        Scanner scan = new Scanner(System.in);
        System.out.println("The last card on the board is: " + board[board.length - 1]);

        while (players[0].hasCards() && players[1].hasCards()) {
            // Computer's turn
            int computerCardIndex = getComputerCardToPlay();
            String cardToPlay = players[1].playCard(computerCardIndex);
            System.out.println("Computer's hand: " + Arrays.toString(players[1].getHand()));
            if (cardToPlay != null && cardToPlay.equals(board[board.length - 1])) {
                players[1].addCards(board);
                board = new String[4];
            } else {
                board[board.length - 1] = cardToPlay;
            }
            System.out.println("Computer played: " + cardToPlay);

            //
            // Player's turn
            System.out.println("Your hand: " + Arrays.toString(players[0].getHand()));
            System.out.println("Enter the index of the card you want to play: ");
            int cardIndex = Integer.parseInt(scan.next());
            String card = players[0].playCard(cardIndex);

            if (card.equals(board[board.length - 1])) {
                players[0].addCards(board);
                board = new String[4];
            } else if (card.equals("J")) {
                players[0].addCards(board);
                board = new String[4];
            } else {
                board[board.length - 1] = card;
            }
        }

        // Display scores
        System.out.println("Player 1 score: " + players[0].getScore());
        System.out.println("Player 2 score: " + players[1].getScore());

        // Add points for player with more cards
        if (players[0].getNumCards() > players[1].getNumCards()) {
            players[0].addScore(3);
        } else if (players[1].getNumCards() > players[0].getNumCards()) {
            players[1].addScore(3);
        }

        // Print the top card on the board after each turn
        System.out.println("The last card on the board is: " + board[board.length - 1]);
    }


    private void dealCards() {
        String[] cards = deck.getCards();
        int index = 4;
        for (int i = 0; i < 4; i++) {
            players[0].addCard(cards[index], i);
            index++;
            players[1].addCard(cards[index], i);
            index++;
        }
    }

    private void dealBoard() {
        String[] cards = deck.getCards();
        int index = 0;
        for (int i = 0; i < 4; i++) {
            board[i] = cards[index];
            index++;
            System.out.println("The last card on the board is: " + board[board.length - 1]);
        }
    }

    private int getComputerCardToPlay() {
        String[] computerHand = players[1].getHand();
        String topCardOnTable = board[board.length - 1];
        int topCardNumber = -1;

        // Convert top card number to integer
        try {
            topCardNumber = Integer.parseInt(topCardOnTable);
        } catch (NumberFormatException e) {
            // If top card is not a number, it must be a J
            topCardNumber = 11;
        }

        // Check if computer has a matching card or a J
        for (int i = 0; i < computerHand.length; i++) {
            String card = computerHand[i];
            if (card != null) {
                int cardNumber = -1;
                try {
                    cardNumber = Integer.parseInt(card);
                } catch (NumberFormatException e) {
                    // If card is not a number, it must be a J
                    cardNumber = 11;
                }

                if (cardNumber == topCardNumber || card.equals("J")) {
                    // Return index of matching card or J
                    return i;
                }
            }
        }

        // If no matching cards or J found
        // Check if computer has a card that is lower than the top card on the table
        for (int i = 0; i < computerHand.length; i++) {
            String card = computerHand[i];
            if (card != null) {
                int cardNumber = -1;
                try {
                    cardNumber = Integer.parseInt(card);
                } catch (NumberFormatException e) {
                    // If card is not a number, it must be a J
                    cardNumber = 11;
                }

                if (cardNumber < topCardNumber) {
                    // Return index of lower card
                    return i;
                }
            }
        }

        // If no matching, lower cards found, return null
        return -1;
    }
}
