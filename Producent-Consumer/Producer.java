package zadanie_2;

public class Producer extends Thread {
    Buffer number;


    public Producer(Buffer b) {
        number = b;
    }

    @Override
    public void run() {
        synchronized (number) {
            while (!Thread.interrupted ()) {
                    number.put ( (int) ((Math.random ()) * 100));
                    try {
                        sleep ( (int) (Math.random () * 2000) );
                    } catch (InterruptedException e) {
                        Thread.currentThread ().interrupt ();
                    }
            }
        }
    }
}
