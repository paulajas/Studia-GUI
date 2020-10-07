package Zadanie_10;

import java.util.Arrays;

public class ArrayBox<T extends Comparable<T>> {

    Object[] arr;

    public ArrayBox(int n){
    arr = new Object[n];
    }

    boolean add(T element){

        int dlugosc=0;

        for (Object t : arr) {
            if (t != null) {
                dlugosc++;
            }
        }
        if(dlugosc == 0){
            arr[dlugosc] = element;
            return true;
        }
        for(int i = 0; i < dlugosc ; i++) {
            T tmp1 = (T) this.arr[i];
            //System.out.println ( tmp1 );
            if (tmp1.compareTo ( element ) == 0)
                return false;
        }
        {
            if (arr.length > dlugosc) {
                arr[dlugosc] = element;
            } else {
                Object[] tmp = Arrays.copyOf ( arr, (dlugosc + 1) );
                arr = tmp;
                arr[dlugosc] = element;
            }
            return true;
        }

    }

    boolean addAll(T[] arr) {

        boolean czyZmiana = false;
        int len = 0;

        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] != null)                                     // przepisywanie tablicy i sprawdzanie gdzie się kończy
                len++;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean czyJest = false;
            if (arr[i] != null) {
                T tmp2 = (T) arr[i];
                //System.out.println ( "Dla " + tmp2 );                                 // tablica dostarczona
                for (int j = 0; j < this.arr.length; j++) {
                    if (this.arr[j] != null) {
                    T tmp1 = (T) this.arr[j];
                    if (tmp1.compareTo ( tmp2 ) == 0)
                        czyJest = true;
                    }
                }
                if (!czyJest) {
                    if (this.arr.length <= len) {
                        Object[] tmp_1 = Arrays.copyOf ( this.arr, (len + 1) );
                        this.arr = tmp_1;
                        this.arr[len] = arr[i];
                        len += 1;
                    } else {
                        this.arr[len] = arr[i];
                        len += 1;
                    }
                }
            }

            if (czyZmiana)
                return true;
        }
            return false;
        }

   public boolean delete(T element) {

       boolean bool = false;
       Object[] tmp = new Object[this.arr.length - 1];
       for (int i = 0; i < this.arr.length; i++) {
           T tmp1 = (T) this.arr[i];
           if (tmp1.compareTo ( element ) == 0) {
               bool = true;
           }
           if (!bool)
               tmp[i] = this.arr[i];
           else if (bool & i<this.arr.length-1)
               tmp[i] = this.arr[i+1];
       }
       this.arr = tmp;
       if (bool)
           return true;
       return false;
       }

   public boolean swap(int a, int b){

        boolean swamping = false;
        if (!swamping) {
            Object tmp = this.arr[a];
            this.arr[a] = this.arr[b];
            this.arr[b] = tmp;
            return true;
        }
        return false;

    }

    void print() {
        for (Object z : arr) {
            System.out.println ( z );
        }
    }
}
