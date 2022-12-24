public class Player {
    private myproject[] hand;
    private int score;

    public Player() {
        hand = new myproject[4];
        score = 0;
    }

    public void addCard(myproject card, int index) {
        hand[index] = card;
    }

    public int calculateScore() {
        for (myproject card : hand) {
            if (card.getRank().equals("Ace")) {
                score += 1;
            } else if (card.getRank().equals("2")) {
                score += 2;
            } else if (card.getRank().equals("Tile 10")) {
                score += 3;
            } else if (card.getRank().equals("Jack")) {
                score += 1;
            } else if (card.getRank().equals("Queen")) {
                score += 2;
            } else if (card.getRank().equals("King")) {
                score += 3;
            }
        }
        return score;
    }

    public void printHand() {
        for (myproject card : hand) {
            System.out.println(card.toString());
        }
    }
}
