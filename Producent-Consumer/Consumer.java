package zadanie_2;

public class Consumer extends Thread{
    Buffer number;

    public Consumer(Buffer c){
        number = c;
    }
    @Override
    public void run() {
        synchronized (number){
            while (!Thread.interrupted ()) {
                    number.get ();
                try {
                    sleep ( (int) (Math.random () * 2000) );
                } catch (InterruptedException e) {
                    Thread.currentThread ().interrupt ();
                }
            }
        }
    }

}
