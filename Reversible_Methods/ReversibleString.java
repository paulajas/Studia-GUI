import java.lang.*;

public class ReversibleString implements Reversible {

   private String str;

   public ReversibleString(String str){
        this.str=str;
   }

   @Override
   public Reversible reverse(){
        char [] character;
        character = str.toCharArray();
        int i = 0;
        for (char ch : character){
            if (Character.isLowerCase(ch)) {
                character[i] =Character.toUpperCase(ch);
                i++;
            }
            else {
                character[i] = Character.toLowerCase(ch);
                i++;
            }
        }

        this.str = new String(character);
        Reversible rev = new ReversibleString(str);
        return rev;
   }

   @Override
   public String toString() {
        return str;
   }
}
