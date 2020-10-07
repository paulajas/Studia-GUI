package GUI8;

import java.util.*;

public class TestFigura {

    public static void main(String[] args)
    {
        Figura fig[] = new Figura[4];
        fig[0] = new Prostokat(1, 1, 4, 9);
        fig[1] = new Kolo(1, 1, 5);
        fig[2] = new Prostokat(2,2,6,6);
        fig[3] = new Prostokat(2,3,5,5);

        // polimorficzne wywołanie metody toString() z klas Kolo/Prostokat,
        // a nie z klasy Figura
        for (Figura f : fig)              // pętla for-each
            System.out.println(f);    // System.out.println(f.toString());

        fig[0].pozycja(12, 12);
        fig[1].pozycja(25, 30);

        for (Figura f : fig){
            System.out.println(f.pole()); //obliczenie pola dla figur
            System.out.println(f.obwod()); //obliczenie obwodu dla figur
        }

        Figura p2 = new Prostokat2(20, 20, 10, 5, '*');
        ((Prostokat2)p2).rysuj(); // testowanie metody rysuj

        // Wyjaśnić dlaczego p2.rysuj() nie działa?
        //typ figura jest zmieniany do typu Prostokat2 który ma inforacje o metodzie rysuj(). Jest ona niedostępna w wyższych klasach
        //jedna z zalet/problemów dziedziczenia

        Kolo2 k2 = new Kolo2(15, 20, 5);

        k2.przesunDo(50, 40);    // przesunięcie środka koła do punktu (50, 40)
        System.out.println(k2);

        k2.powrot();                    // powrót do poprzedniej pozycji (bezpośrednio przed przesunięciem) środka koła
        System.out.println(k2);

        List<Figura> listaFig = new ArrayList<Figura>();
        for (int i = 0; fig.length > i; i++)
            listaFig.add(fig[i]);



        System.out.println("\n Figury przed sortowaniem: \n");
        for (Figura f : fig)
            System.out.println(f);

        //Collections.sort(listaFig,Figura::compareTo);

        listaFig.sort(Figura::compareTo);
            /*
         (figura, f) -> {
             return figura.compareTo(f);
         });

           */
        System.out.println("\n Figury po sortowaniu: \n");
        for (Figura f : fig)
            System.out.println(f);


    }
}

