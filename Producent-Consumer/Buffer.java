package zadanie_2;

public class Buffer {

    private int[] arr;
    private int currentSize = 0;        //index tablicy

    public Buffer(int n){
        arr = new int[n];
    }

    public synchronized void put(int element){

        if (currentSize < arr.length-1) {
            arr[currentSize] = element;
            currentSize++;
            System.out.println ("Zostala dostarczona liczba: " + element);
        }
        else{
            try {
                System.out.println ("Oczekuje na wolne miejsce");
                wait ();
            }catch(InterruptedException e){
                e.printStackTrace ();
            }
        }
        notify ();
    }

    public synchronized int get() {
        while (currentSize-1 < 0) {
            try {
                System.out.println ("Oczekuje na liczby");
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        int element=arr[0];
        System.out.println ("Zostala zutylizowana liczba: " + element);
        for ( int i=0; i < arr.length-1; i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1] = 0;
        currentSize--;
        notify();
        return element;
    }
}
