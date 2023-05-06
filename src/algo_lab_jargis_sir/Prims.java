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
 * @author rumon
 */
public final class Prims {

    static int node, edge, graph[][], key[], parent[], tree[], mstset[], root;

    Prims() {
        try {
//          File bfsfile = new File("/home/student_user/Desktop/prims.txt");
            File bfsfile = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "prims.txt");
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
        tree = new int[node];
        mstset = new int[node];

        for (int i = 0; i < node; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            tree[i] = 0;
            mstset[i] = 0;
        }
        key[root] = 0;

        for (int count = 0; count < node - 1; count++) {
            int u = minKey(key, mstset);
            mstset[u] = 1;
            for (int v = 0; v < node; v++) {
                if (graph[u][v] != 0 && mstset[v] == 0 && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }

    private int minKey(int key[], int mstSet[]) {
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

    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < node; i++) {
            System.out.println(parent[i] + " − " + i + "\t" + graph[i][parent[i]]);
        }

    }

    public static void main(String[] args) {
        new Prims();
    }
}
