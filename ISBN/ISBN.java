package ISBN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ISBN {

    private String numer;
    private int[] arr;

    public ISBN(String numer){
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(numer);
        StringBuffer sb = new StringBuffer (  );
        int count = 0;
        while(m.find()){
            count++;
            sb.append (m.group ());
        }
        String check = sb.toString ();
        if(isValid(check)){
            this.numer=check;
        }
    }

    @Override
    public String toString() {
        if (numer != null)
        return "ISBN numer = " + numer;
        else
            return "It is not a valid ISBN";
    }
    private boolean isValid(String numer){
        int suma = 0;
        if(numer.length() == 10){
            for (int i = 1; i < 10 ; i++){
                int j = numer.charAt(i-1)-48;
                suma+=j*i;
            }
            if(suma%11 == numer.charAt(9)-48)
                return true;
        }else if(numer.length ()==13) {
            for (int i = 1; i < 13 ; i++) {
                int j = numer.charAt ( i - 1 ) - 48;
                if (i % 2 == 0) {
                    suma += j;
                } else
                    suma+= j*3;
            }
            if(10 - suma%10 == numer.charAt(12)-48)
                return true;
            }
            return false;
    }
}
