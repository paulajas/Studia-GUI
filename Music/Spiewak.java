package Music;

public abstract class Spiewak {
    protected String nazwisko;
    protected int nrStartowy;
    private static int nr=0;

    public Spiewak(String nazwisko){
        this.nazwisko=nazwisko;
        nrStartowy=++nr;
    }

    abstract String spiewaj();

    @Override
    public String toString() {
        return "(" + nrStartowy + ") " +nazwisko + ": "+ spiewaj();
    }



    static Spiewak najglosniej(Spiewak[] arr){

        Spiewak tmp = arr[0];
        int najwyzszeLiczenie=0;

        for (Spiewak sp : arr) {
            String str = sp.spiewaj();
            str=str.toLowerCase();

            StringBuilder sb = new StringBuilder();
            char[] litery = str.toCharArray();

            for(int i =0; i<litery.length; i++) {

                if(Character.isLetter(litery[i]))
                    sb.append(litery[i]);
            }
            long t =sb.chars().distinct().count();

            if (t>najwyzszeLiczenie) {
                tmp = sp;
                najwyzszeLiczenie = (int) t;
            }
        }

        return tmp;
    }
}