package org.example;

import java.util.*;

public class Homework2
{
    public static class Output
    {
        public String messaggio;
        public String[] nomi;
        public ArrayList<Integer> numeri;
        public Output(String mess)
        {
            this.messaggio = mess;
        }
        public Output(String[] nom, ArrayList<Integer> num)
        {
            this.nomi = nom;
            this.numeri = num;
        }
    }
    public static void main(String[] args) throws RuntimeException {
        // Parte 1: Gestione dell'input
        int n = 1;
        int m = 1;

        String[] nomi = {"Fabio"};
        int[] numeri = {1,2};

        Output output = effettuaOperazioni(n, m, nomi, numeri);
        System.out.println(output.messaggio);
    }

    public static Output effettuaOperazioni(int n, int m, String[] nomi, int[] numeri) throws RuntimeException
    {

        if (n != m) {
            return new Output("Il numero di numeri e nomi inseriti non corrisponde");
        }
        else
        {
            if (n <= 0) {
                return new Output("Non e' possibile inserire una grandezza di dimensione 0 o minore");

            } else {
                if (nomi == null || numeri == null) {
                    return new Output("Una delle due o entrambe le liste sono nulle");
                }

                if (nomi.length != m || numeri.length != n) {
                    return new Output("La lunghezza di uno dei due o entrambe le liste non corrisponde alla dimensione fornita in input");
                }
                for (int i = 0; i <= n - 1; i++) {
                    if (numeri[i] < 0) {
                        return new Output("Non e' possibile inserire un numero negativo");
                    }
                    if (numeri[i] > 99) {
                        return new Output("Il numero inserito e' troppo grande");
                    }
                    if (nomi[i] == null) {
                        return new Output("Non e' possibile inserire stringhe nulle");
                    }
                }

            }

            // Calcola il quadrato dei numeri pari e il cubo dei numeri dispari
            List<Integer> quadrati = new ArrayList<>();
            List<Integer> cubi = new ArrayList<>();
            for (int i = 0; i <= n - 1; i++) {
                if (numeri[i] % 2 == 0) {
                    int quadrato = numeri[i] * numeri[i];
                    if (quadrato < 100) {
                        quadrati.add(quadrato);
                    }
                } else {
                    int cubo = numeri[i] * numeri[i] * numeri[i];
                    if (cubo < 200) {
                        cubi.add(cubo);
                    }
                }
            }

            // Unisci i quadrati e i cubi in un unico array e ordina il tutto
            ArrayList<Integer> numeriOrdinati = new ArrayList<>();
            numeriOrdinati.addAll(quadrati);
            numeriOrdinati.addAll(cubi);
            Collections.sort(numeriOrdinati);


            Arrays.sort(nomi);
            Output output = new Output(nomi, numeriOrdinati);
            return output;
        }
    }
}
