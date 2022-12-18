import java.util.Random;

public class deck {

    private static final int NUM_CARDS = 52;
    private static final String[] SUITS = {"♠", "♣", "♥", "♦"};
    private static final String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    private String[] cards;

    public void Deck() {
        cards = new String[NUM_CARDS];
        int i = 0;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                cards[i++] = rank + " of " + suit;
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < NUM_CARDS; i++) {
            int j = rand.nextInt(NUM_CARDS);
            String temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }

    }


    public void cut() {
        Random rand = new Random();
        int cutPos = rand.nextInt(NUM_CARDS);
        String[] newCards = new String[NUM_CARDS];
        for (int i = 0; i < NUM_CARDS; i++) {
            newCards[i] = cards[(cutPos + i) % NUM_CARDS];
        }
        cards = newCards;
    }

    public String[] getCards() {
        return cards;
    }

    public String[][] dealCards() {
        String[][] hands = new String[2][4];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            hands[0][i] = cards[index];
            index++;
            hands[1][i] = cards[index];
            index++;
        }
        return hands;
    }

    public String[] dealBoard() {
        String[] board = new String[4];
        int index = 8;
        for (int i = 0; i < 4; i++) {
            board[i] = cards[index];
            index++;
        }
        return board;
    }

    public void playGame() {
        cut();
        String[][] hands = dealCards();
        String[] board = dealBoard();

        System.out.println("The last card on the board is: " + board[board.length - 1]);
    }
}