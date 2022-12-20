

public class Main {
    public static void main(String[] args) {
        deck deck = new deck();
        Game game=new Game(deck);
        game.playGame();


        deck.shuffle();


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