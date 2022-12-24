public class myproject {
   private String rank;
   private String suit;

   public myproject(String rank, String suit) {
      this.rank = rank;
      this.suit = suit;
   }

   public String getRank() {
      return rank;
   }

   public String getSuit() {
      return suit;
   }

   public String toString() {
      return rank + " of " + suit;
   }
}
