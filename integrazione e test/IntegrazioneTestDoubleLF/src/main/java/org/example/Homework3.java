package org.example;

import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Homework3 {
    private final static int n = 3; //Constante per definire il numero di elementi all'interno della scheda
    public static void main(String[] args) {
        int[] scheda = new int[]{4, 50, 20};

        for (int i = 0; i < 250000; i++) {
            boolean vincita = superenalotto(scheda, schedaVincente());
            if (vincita) {
                System.out.println("Hai vinto al tentativo " + i);
            }
        }
    }
    public static boolean superenalotto(int[] scheda, int[] schedaVincente) {

        boolean[] flag = new boolean[n];
        boolean[] correct = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (scheda[i] < 1 || scheda[i] > 90) {
                throw new InvalidParameterException();
            }
            correct[i] = true;
        }

        int j = 0;
        for (int i : scheda) {
            flag[j] = searchElement(schedaVincente, i);
            if (flag[j]) {
                schedaVincente[searchPosition(schedaVincente, i)] = 0;
            }
            j++;
        }
        return Arrays.equals(flag, correct);
    }

    public static boolean searchElement(int[] array, int target) {
        for (int j : array) {
            if (j == target) {
                return true; // Restituisce true se l'elemento viene trovato
            }
        }
        return false; // Restituisce false se l'elemento non viene trovato
    }

    private static int searchPosition(int[] array, int target) {
        int i = 0;
        for (int j : array) {
            if (j == target) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int[] schedaVincente() {
        int[] schedaVincente = new int[n]; // Array per contenere i numeri casuali

        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < n; i++) {
            int randomNumber = 1 + secureRandom.nextInt(90); // Genera un numero casuale compreso tra 1 e 90
            schedaVincente[i] = randomNumber; // Inserisce il numero casuale nell'array
        }

        return schedaVincente;
    }

    public static boolean haveSameElements(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        int[] copyArray1 = Arrays.copyOf(array1, array1.length);
        int[] copyArray2 = Arrays.copyOf(array2, array2.length);

        Arrays.sort(copyArray1);
        Arrays.sort(copyArray2);

        return Arrays.equals(copyArray1, copyArray2);
    }

}

