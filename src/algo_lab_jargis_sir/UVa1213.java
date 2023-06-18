/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algo_lab_jargis_sir;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author rumon
 */
public class UVa1213 {

    static LinkedList<Integer> primes;
    static int n, k, nprime, occurance = 0, limit, mem[][][];

    static int seieve(int n) {
        nprime = 0;
        primes = new LinkedList<>();
        int mark[] = new int[1121];
        mark[0] = 1;
        mark[1] = 1;
        for (int k = 4; k <= n; k += 2) {
            mark[k] = 1;
        }
        primes.add(2);
        nprime++;
        for (int k = 3; k <= n; k += 2) {
            if (mark[k] == 0) {
                primes.add(k);
                nprime++;
                if (k <= limit) {
                    for (int j = k*k; j <= n; j += k * 2) {
                        mark[j] = 1;
                    }
                }
            }
        }
        return nprime;
    }

    static int subsetSum(int n, int pos, int sum, int k) {
        if (sum > 0 && k == 0) {
            return 0;
        }
        if (sum == 0 && k == 0) //Sum found
        {
            return 1;
        } else if (pos >= n || sum < 0 || k < 0) //Out of bounds
        {
            return 0;
        }
        if (mem[pos][sum][k] != -1) {
            return mem[pos][sum][k];
        }
        int a = subsetSum(n, pos + 1, sum - primes.get(pos), k - 1);
        int b = subsetSum(n, pos + 1, sum, k);

        mem[pos][sum][k] = a + b;
        return a + b;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        limit = (int) (Math.sqrt(n) + 2);
        int count = seieve(n);
        mem = new int[count + 1][n + 1][k + 1];
        for (int u = 0; u <= count; u++) {
            for (int v = 0; v <= n; v++) {
                for (int w = 0; w <= k; w++) {
                    mem[u][v][w] = -1;
                }
            }
        }
        int h = subsetSum(count, 0, n, k);
        System.out.println(h);

        sc.close();
    }
}
