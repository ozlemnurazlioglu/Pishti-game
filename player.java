public class player {
    private myproject[] hand;
    private int score;

    public player() {
        hand = new myproject[4];
        score = 0;
    }

    public void addCard(myproject card, int index) {
        hand[index] = card;
    }

    

    public void printHand() {
        for (myproject card : hand) {
            System.out.println(card.toString());
        }
    }
}
