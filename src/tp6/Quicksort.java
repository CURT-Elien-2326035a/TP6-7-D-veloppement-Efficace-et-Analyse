package tp6;

import java.util.Random;

public class Quicksort {

    public static void randomInit(int[] input, int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            input[i] = rand.nextInt(size);
        }
    }

    public static void quicksort(int[] T, int premier, int dernier) {
        if (premier < dernier) {
            int pivot = choixPivot(T, premier, dernier);
            pivot = partitionner(T, premier, dernier, pivot);
            quicksort(T, premier, pivot - 1);
            quicksort(T, pivot + 1, dernier);
        }
    }

    public static int partitionner(int[] T, int premier, int dernier, int pivot) {
        echanger(T, pivot, dernier);
        int j = premier;
        for (int i = premier; i < dernier; i++) {
            if (T[i] <= T[dernier]) {
                echanger(T, i, j);
                j++;
            }
        }
        echanger(T, dernier, j);
        return j;
    }

    public static void echanger(int[] T, int i, int j) {
        int temp = T[i];
        T[i] = T[j];
        T[j] = temp;
    }

    public static int choixPivot(int[] T, int premier, int dernier) {
        return (premier + dernier) / 2; // pivot au milieu
    }

    }
