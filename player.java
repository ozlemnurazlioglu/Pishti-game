public class Player {
    private String[] hand;
    private int score;
    public Player() {
        hand = new String[4];
        score = 0;
    }

    public void addCard(String card, int index) {
        hand[index] = card;
    }

    public void addCards(String[] cards) {
        for (String card : cards) {
            if (card.equals("♦10")) {
                score += 3;
            } else if (card.equals("♣2")) {
                score += 2;
            } else {
                score += 1;
            }
        }
    }

    public void addScore(int points) {
        score += points;
    }

    public int getNumCards() {
        int count = 0;
        for (String card : hand) {
            if (card != null) {
                count++;
            }
        }
        return count;
    }

    public boolean hasCards() {
        return getNumCards() > 0;
    }

    public String playCard(int index) {
        String card = hand[1];
        hand[index] = null;
        return card;
    }

    public String[] getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }
}