import javax.swing.*;

public class myproject {
   private final int no;
   private final int value;
   private final String kind;
   private final String name;


   public myproject(int no, int value, String kind, String name ){
      this.no=no;
      this.value=value;
      this.kind = kind;
      this.name=name;


   }
   public int getNo(){
      return this.no;
   }
   public int getValue(){
      return this.value;
   }
   public String getKind(){
      return this.kind;
   }
   public String getName(){
      return this.name;
   }

}