/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algo_lab_jargis_sir;

import java.util.Scanner;

/**
 *
 * @author rumon
 */
class qcksort {

    void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    int partition(int arr[], int l, int r) {
        int pivot = l;
        int too_big_idx = l + 1;
        int too_small_idx = r;
        while (too_small_idx >= too_big_idx) {
            while (arr[too_big_idx] <= arr[pivot]) {
                too_big_idx++;
                if (too_big_idx > r) {
                    break;
                }
            }

            while (arr[too_small_idx] > arr[pivot]) {
                too_small_idx--;
            }

            if (too_big_idx < too_small_idx) {
                swap(arr, too_big_idx, too_small_idx);
            }
        }

        swap(arr, too_small_idx, pivot);
        return too_small_idx;
    }

    void quickSort(int a[], int beg, int end) {
        int loc;
        if (beg < end) {
            loc = partition(a, beg, end);
            quickSort(a, beg, loc - 1);
            quickSort(a, loc + 1, end);
        }
    }
}

public class Quicksort {

    static int n = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        qcksort qs = new qcksort();
        qs.quickSort(arr, 0, arr.length - 1);
        System.out.println("The sorted array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
