import javax.swing.*;

public class Main{

    public static void main(String[] args) {
        deck d1 = new deck();
        d1.shuffle();
        for (int d=0; d<52;d++){
            JOptionPane.showMessageDialog(null,
                    d1.showcard(d1.getNumberofcards()-1).toString(),
                    "card",
                    JOptionPane.PLAIN_MESSAGE,
                    d1.givecard().getimage());

        }


    }

}
