/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algo_lab_jargis_sir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rumon
 */
public class SecondMst {

    static int node, edge, graph[][], sKey[], key[], parent[], secondParent[], printParent[], mstset[], root, total = 0, cTotal = 0, max = Integer.MAX_VALUE;

    SecondMst() {
        try {
          File bfsfile = new File("/home/student_user/Desktop/prims.txt");
            try (Scanner bfs_scanner = new Scanner(bfsfile)) {
                node = bfs_scanner.nextInt();
                edge = bfs_scanner.nextInt();

                graph = new int[node][node];
                for (int i = 0; i < edge; i++) {
                    int edge_a = bfs_scanner.nextInt();
                    int edge_b = bfs_scanner.nextInt();
                    int weight = bfs_scanner.nextInt();
                    graph[edge_a][edge_b] = weight;
                    graph[edge_b][edge_a] = weight;
                }
                root = bfs_scanner.nextInt();
                bfs_scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("\"prims.txt\" file not found in your Desktop forder");
            System.exit(0);
        }

        key = new int[node];
        parent = new int[node];
        mstset = new int[node];
        secondParent = new int[node];
        printParent = new int[node];
        sKey = new int[node];

        for (int i = 0; i < node; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mstset[i] = 0;
        }
        key[root] = 0;

        for (int count = 0; count < node - 1; count++) {
            int u = minKey(key, mstset);
            total += key[u];
            mstset[u] = 1;
            for (int v = 0; v < node; v++) {
                if (graph[u][v] != 0 && mstset[v] == 0 && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];

                }
            }
        }
        int g = minKey(key, mstset);
        total += key[g];

        System.out.println(total);

//      calculate second mst
        for (int omit = 1; omit < node; omit++) {
            int flag = 0;
            cTotal = 0;
            for (int i = 0; i < node; i++) {
                sKey[i] = Integer.MAX_VALUE;
                secondParent[i] = -1;
                mstset[i] = 0;
            }
            sKey[root] = 0;
            for (int count = 0; count < node - 1; count++) {
                int u = minKey(sKey, mstset);
                if (u == -1) {
                    flag = 1;
                    break;
                }
                cTotal += sKey[u];
                mstset[u] = 1;
                for (int v = 0; v < node; v++) {
                    if ((v == omit && u == parent[omit]) || (v == parent[omit] && u == omit)) {
                        continue;
                    }
                    if (graph[u][v] != 0 && mstset[v] == 0 && graph[u][v] < sKey[v]) {
                        secondParent[v] = u;
                        sKey[v] = graph[u][v];
                    }
                }
            }
            if (flag == 0) {
                g = minKey(sKey, mstset);
                cTotal += sKey[g];
            }
            if (cTotal <= max && flag == 0) {
                max = cTotal;
                System.arraycopy(secondParent, 1, printParent, 1, node - 1);
            }
        }

        printMST(parent, graph);
        System.out.println("\n\n");
        System.out.println(cTotal);
        printMST(printParent, graph);
    }

    static int minKey(int key[], int mstSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < node; v++) {
            if (mstset[v] == 0 && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    static void printMST(int parent[], int graph[][]) {
        try {
            try (FileWriter myWriter = new FileWriter(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "primsans.txt", true)) {
                myWriter.write("Edge \tWeight\n");
                for (int i = 1; i < node; i++) {
                    myWriter.write(parent[i] + " − " + i + "\t" + graph[i][parent[i]] + "\n");
                }
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

        System.out.println("Edge \tWeight");
        for (int i = 1; i < node; i++) {
            System.out.println(parent[i] + " − " + i + "\t" + graph[i][parent[i]]);
        }

    }

    public static void main(String[] args) {
        new SecondMst();
    }
}
