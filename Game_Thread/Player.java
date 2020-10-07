public class Player extends Thread{

    private static int ID;
    protected int points, id;

    public Player( String nazwa){
        super(nazwa);
        id=++ID;
    }
    @Override
    public void run() {
        while (true) {
            try {
                sleep((int)(Math.random()*2000));
            }
            catch (InterruptedException e) {
                //e.printStackTrace ();
                return;
            }
            points+=Math.random()*100;
        }
    }
}
