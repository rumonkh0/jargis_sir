/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jargis;

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
                System.out.print("For creating partition with pivot " + arr[pivot] + " swaping " + (too_big_idx - l) + "th and " + (too_small_idx - l) + "th element of the array is ");

                swap(arr, too_big_idx, too_small_idx);
                for (int m = l; m <= r; m++) {
                    System.out.print(arr[m] + " ");
                }
                System.out.println("");
            }
        }

        swap(arr, too_small_idx, pivot);
        System.out.println("The pivot position is " + (too_small_idx - l) + " and swaping with " + (too_small_idx - l) + "th element");

        return too_small_idx;
    }

    void quickSort(int a[], int beg, int end) {
        int loc;
        if (beg < end) {
            System.out.print("the partition array is: ");
            for (int m = beg; m <= end; m++) {
                System.out.print(a[m] + " ");
            }
            System.out.println("\nThe pivot is " + a[beg]);
            loc = partition(a, beg, end);
//            System.out.println("The pivot position is " + (loc + 1) + " and swaping with " + (loc + 1) + "th element");
            System.out.print("now the two partition is: ");
            for (int m = beg; m < loc; m++) {
                System.out.print(a[m] + " ");
            }
            System.out.print("|" + a[loc] + "| ");
            for (int m = loc + 1; m <= end; m++) {
                System.out.print(a[m] + " ");
            }
            System.out.println("\n");
            quickSort(a, beg, loc - 1);
            quickSort(a, loc + 1, end);
        }
    }
}

public class Quicksort {
    static int n=10;

    public static void main(String[] args) {
//        int[] arr = {40, 20, 10, 80, 60, 50, 70, 30, 90, 100};
//        int[] arr = {5,  9, 11, 15,18, 20, 26};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int size = sc.nextInt();
//        int arr[]= new int[size];
//        for(int i=0; i<size; i++){
//            arr[i]=sc.nextInt();
//        }
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=(int) (Math.random()*100);
        }
        qcksort qs = new qcksort();
        qs.quickSort(arr, 0, arr.length - 1);
        System.out.println("The sorted array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
