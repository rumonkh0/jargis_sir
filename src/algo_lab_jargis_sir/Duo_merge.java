/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algo_lab_jargis_sir;

import java.util.Scanner;

/**
 *
 * @author rumon
 */
public class Duo_merge {

    void merge(int arr[], int left, int mid, int right) {
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

    }

    void mergesort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    void two_array_merge(int arr1[], int n1, int arr2[], int n2, int last[]) {
        int i = 0, j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                last[k] = arr1[i];
                i++;
            } else {
                last[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            last[k] = arr1[i];
            i++;
            k++;
        }

        while (j < n2) {
            last[k] = arr2[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        //take input for first array
        int n1;
        Scanner obj = new Scanner(System.in);
        n1 = obj.nextInt();
        int arr1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = obj.nextInt();
        }

        //take input for second array
        int n2;
        n2 = obj.nextInt();
        int arr2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = obj.nextInt();
        }

        //sort individual array
        Duo_merge ob = new Duo_merge();
        ob.mergesort(arr1, 0, n1 - 1);
        ob.mergesort(arr2, 0, n2 - 1);

        //merge two arrays
        int arr3_size = n1 + n2;
        int last[] = new int[arr3_size];
        ob.two_array_merge(arr1, n1, arr2, n2, last);

        // Printing the output
        System.out.println("Sorted array");
        for (int i = 0; i < arr3_size; i++) {
            System.out.println(last[i] + "");
        }
    }
}
