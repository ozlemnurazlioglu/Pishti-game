import Player.Player;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Player[] players;
    private String[] board;
    private deck deck;
    private HighScoreList highScores;


    public Game(deck deck) {
        this.deck = deck;
        this.players = new Player[2];
        this.players[0] = new Player();
        this.players[1] = new Player();
        this.board = new String[4];
        this.highScores = new HighScoreList();
    }

    public void playGame() {

        deck.cut();
        dealCards();
        dealBoard();
        Scanner scan = new Scanner(System.in);
        System.out.println("The last card on the board is: " + board[board.length - 1]);


        while (players[0].hasCards() && players[1].hasCards()) {
            // Computer's turn
            String cardToPlay = getComputerCardToPlay();
            if (getComputerCardToPlay().equals(board[board.length - 1])) {
                players[1].addCards(board);
                board = new String[4];
            } else {
                board[board.length - 1] = cardToPlay;
            }

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

        if (players[0].getNumCards() > players[1].getNumCards()) {
            players[0].addScore(3);
        } else if (players[1].getNumCards() > players[0].getNumCards()) {
            players[1].addScore(3);
        }
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
        }
    }

    private String getComputerCardToPlay() {
        // choose a random card from the computer's hand
        Random rand = new Random();
        int index = rand.nextInt(4);
        return players[1].playCard(index);
    }
}