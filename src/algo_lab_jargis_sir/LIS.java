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
//10 9 2 5 3 7 11 8 10 13 6
public class LIS {

    static int size, arr[], length[], prev[];

    static int findMax() {
        int max = 0;
        int index = 0;
        for (int i = size; i >= 0; i--) {
            if (length[i] > max) {
                max = length[i];
                index = i;
            }
        }
        return index;
    }

    static void printSequence(int max) {
        if (max == 0) {
            return;
        }
        printSequence(prev[max]);
        System.out.print(arr[max] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        arr = new int[size + 1];
        length = new int[size + 1];
        prev = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            arr[i] = sc.nextInt();
        }
        arr[0] = 0;
        length[0] = 0;
        prev[0] = -1;

        for (int i = 0; i <= size; i++) {
            int len = 0, previ=-1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    if(len<length[j]){
                        len=length[j];
                        previ=j;
                    }
                }
            }
            length[i] = len + 1;
            prev[i]=previ;
        }

        System.out.println("Here is the sequence: ");
        printSequence(findMax());
        System.out.println("");
    }
}
