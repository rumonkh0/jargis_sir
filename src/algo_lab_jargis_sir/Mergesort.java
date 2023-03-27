package algo_lab_jargis_sir;

import java.util.Scanner;

/**
 *
 * @author rumon
 */
public class Mergesort {

    void merge(int arr[], int left, int mid, int right) {

        //Printing code
        System.out.println("merging array: ");
        System.out.print("[ ");
        for (int i = left; i <= mid; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("] and [ ");
        for (int i = mid + 1; i <= right; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("] to ");

        //Main code
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + i + 1];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        //Pringting code
        System.out.print("[ ");
        for (var m = left; m <= right; m++) {
            System.out.print(arr[m] + " ");
        }
        System.out.print("]\n");

    }

    void mergesort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            //Printing code
            System.out.println("dividing array: ");
            System.out.print("[ ");
            for (int i = left; i <= right; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("] to ------> ");
            System.out.print("[ ");
            for (int i = left; i <= mid; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("] and [ ");
            for (int i = mid + 1; i <= right; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("]\n");

            //Main code
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner obj = new Scanner(System.in);
        n = obj.nextInt();
        int arr[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = obj.nextInt();
//        }

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        Mergesort ob = new Mergesort();
        ob.mergesort(arr, 0, n - 1);

        // Printing the output
        System.out.println("Sorted array");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
