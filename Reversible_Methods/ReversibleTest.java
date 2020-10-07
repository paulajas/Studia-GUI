public class ReversibleTest {
    public static void main(String[] args){
        Reversible[] revers = new Reversible[] {
                new ReversibleString("Kot2020"),
                new ReversibleInt(2),
                new ReversibleInt(3),
                new ReversibleString("Pies"),
                new ReversibleString("Ala ma kota i psa"),
                new ReversibleInt(10)
        };

        System.out.println("Normalne:");
        for (Reversible r : revers) {
            System.out.println(r);
        }

        for (Reversible r : revers) {
            r.reverse();
        }

        System.out.println("Odwrócone:");
        for (Reversible r : revers) {
            System.out.println(r);
        }

        System.out.println("Przywrócone i zmienione:");
        for (Reversible r : revers) {
            if (r instanceof ReversibleString){
                r.reverse();
                System.out.println("Tekst " + r);
            }
            else {
                r.reverse();
                r = new ReversibleInt(10 + Integer.valueOf(r.toString()));
                System.out.println(r);
            }
        }
    }
}

