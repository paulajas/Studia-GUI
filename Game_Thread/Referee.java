public class Referee extends Thread{

    private int czasGry;            //w sekundach
    private int przebieg;           //w sekundach
    private Player[] arr;

    public Referee (int czasGry, Player[] arr){
        this.czasGry = czasGry;
        this.arr = arr;
    }

    @Override
    public void run() {
        while (przebieg < czasGry) {
            try {
                sleep ( 1000 );
                System.out.println ( "Czas " + ++przebieg );
                for (Player p : arr) {
                    System.out.println ( p.getName () + " " + p.points );
                }
            } catch (InterruptedException e) {
                //e.printStackTrace ();
                return;    // wazne w momencie przerwania dzialania watku (przez inny watek)
            }
        }
            for (Player z : arr) {
                    z.interrupt ();

        }
    }

    public void startGame(){
        this.start();
        for (Player p : arr)
            p.start();
    }

    public void result(){
        for (Player p : arr )
            System.out.println ("Results: " + p.getName () + " " + p.points);

        if(arr[0].points > arr[1].points)
            System.out.println ("The winner is " + arr[0].getName () + "!");

        else if(arr[0].points < arr[1].points)
            System.out.println ("The winner is " + arr[1].getName () + "!");
        else if(arr[0].points == arr[1].points)
            System.out.println ("Remis!");
    }

}
