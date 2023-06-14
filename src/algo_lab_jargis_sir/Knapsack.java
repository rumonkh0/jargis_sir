/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algo_lab_jargis_sir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author student_user
 */
public class Knapsack {

    static int n, W, val[], w[], dp[][], taken[][];

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int knapsack() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    taken[i][j] = 0;
                } else if (w[i - 1] <= j) {
                    int a, b;
                    if (taken[i - 1][j - w[i - 1]] == 1) {
                        a = val[i - 1] + dp[i - 2][j - w[i - 1]];
                    } else {
                        a = val[i - 1] + dp[i - 1][j - w[i - 1]];
                    }
                    b = dp[i - 1][j];

                    if (a > b) {
                        dp[i][j] = a;
                        taken[i][j] = 1;
                    } else {
                        dp[i][j] = b;
                        taken[i][j] = 0;
                    }

//                    dp[i][j] = max(a, );
                } else {
                    dp[i][j] = dp[i - 1][j];
                    taken[i][j] = 0;
                }
            }
        }
        return dp[n][W];
    }

    static void bctrk(int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (taken[i][j] == 1) {
            if (taken[i - 1][j - w[i - 1]] == 1) {
                bctrk(i - 2,j - w[i - 1]);
            } else {
                bctrk(i - 1,j - w[i - 1]);
            }
            System.out.print(i+" ");
        } else {
            bctrk(i-1,j);
        }
    }

    public static void main(String[] args) {
        try {
            File bfsfile = new File("/home/rumon/Desktop/khap.txt");
            try ( Scanner bfs_scanner = new Scanner(bfsfile)) {
                n = bfs_scanner.nextInt();
                W = bfs_scanner.nextInt();

                dp = new int[n + 1][W + 1];
                taken = new int[n + 1][W + 1];
                val = new int[n];
                w = new int[n];
                for (int i = 0; i < n; i++) {
                    w[i] = bfs_scanner.nextInt();
                    val[i] = bfs_scanner.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found in your Desktop forder");
            System.exit(0);
        }

        Knapsack ob = new Knapsack();
        int ans = ob.knapsack();
        System.out.println(ans);
        ob.bctrk(n, W);

        //input print-------------------------------
//        for(int i=0; i<n; i++){
//            System.out.println(w[i]+" "+val[i]);
//        }
    }
}