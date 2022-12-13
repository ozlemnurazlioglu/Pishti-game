import javax.swing.*;
import java.util.Objects;

public class deck {
    public static void main(String[] args) {
        String[] kind = {"♠", "♣", "♥", "♦"};
        String[] name = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] deck= new String[52];
        for(int i=0;i<deck.length;i++){
            deck[i] =name[i%13]+kind[i/13];

        }
        for (int i =0;i<deck.length;i++){
            int index =(int)(Math.random()* deck.length);

            String temp=deck[i];
            deck[i]=deck[index];
            deck[index]=temp;

        }
        for (String u:deck){
            System.out.println(u);
        }
    }

}