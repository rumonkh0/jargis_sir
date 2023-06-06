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
public class AllLcs {
    static void print() {
        System.out.println("here is output");
    }

    static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int m = s1.length();
        int n = s2.length();

        char x[] = s1.toCharArray();
        char y[] = s2.toCharArray();

        int lcs[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            lcs[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            lcs[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        System.out.println("the length is : " + lcs[m][n]);
        print();
    }
}
