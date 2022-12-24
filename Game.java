public class Game {

    private String[][] hands;
    private String[] board;
    private deck deck;


    public Game(deck deck) {
        this.deck = deck;
        this.hands = new String[2][4];
        this.board = new String[4];
    }

    public void playGame() {
        deck.cut();
        dealCards();
        dealBoard();

        System.out.println("The last card on the board is: " + board[board.length - 1]);
    }

    private void dealCards() {
        String[] cards = deck.getCards();
        int index = 0;
        for (int i = 0; i < 4; i++) {
            hands[0][i] = cards[index];
            index++;
            hands[1][i] = cards[index];
            index++;
        }
    }

    private void dealBoard() {
        String[] cards = deck.getCards();
        int index = 8;
        for (int i = 0; i < 4; i++) {
            board[i] = cards[index];
            index++;
        }
    }
}
