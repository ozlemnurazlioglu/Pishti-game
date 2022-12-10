import javax.swing.*;

public class deck {
    private final String[] kind={"Ace","Jack", "Queen", "King"};
    private final String[] name={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private int numberofcards;
    private myproject[] cards;

    public deck() {
        cards=new myproject[52];
        numberofcards=0;
        for (int k=0; k< kind.length; k++){
            for (int n=0; n< name.length; n++){

                cards[numberofcards]= new myproject(numberofcards, value,kind[k],name[n],
                        new ImageIcon(getClass().getResource("/Bu bilgisayar/Resimler/Ekran Görüntüleri/"+kind[k]+"-"+name[n]+".png")));


            }
        }
    }
}