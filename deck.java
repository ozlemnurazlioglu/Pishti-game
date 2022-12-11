import javax.swing.*;
import java.util.Objects;

public class deck {
    private final String[] kind = {"S", "D", "C", "H"};
    private final String[] name = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private int numberofcards;
    private myproject[] cards;

    public deck() {
        cards = new myproject[52];
        numberofcards = 0;
        for (int k = 0; k < kind.length; k++) {
            for (int n = 0; n < name.length; n++) {
                int value = n > 9 ? 10 : n + 1;


                cards[numberofcards] = new myproject(numberofcards, value, kind[k], name[n],
                        new ImageIcon(Objects.requireNonNull(getClass().getResource("/Ekran görüntüsü/" + kind[k] + "-" + name[n] + ".png"))));
                numberofcards++;


            }
        }
        System.out.println("Deck has been created"+numberofcards+"There are 52 cards.");
    }

    public myproject givecard() {
        numberofcards--;
        System.out.println("Remainin card=" + numberofcards);
        return cards[numberofcards];
    }
    public myproject showcard (int no){
        return cards[no];
    }

    public int getNumberofcards() {
        return numberofcards;
    }

    public void shuffle() {
        int i;
        for (int k = 0; k < cards.length; k++) {
            i = (int) (Math.random()) * cards.length;
            myproject tmp = cards[k];
            cards[k] = cards[i];
            cards[i] = tmp;

        }
        numberofcards = 52;

    }

}