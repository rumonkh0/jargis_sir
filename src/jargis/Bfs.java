package jargis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author rumon
 */
class BFS {

    static int node, edge, vis[], lev[], par[], s;
//    static LinkedList<Integer> graph[];
    static int graph[][];

    BFS() {
//        Scanner sc = new Scanner(System.in);

        try {
//            File myObj = new File("bfs.txt");
            File myObj = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "bfs.txt");
            try (Scanner fileManager = new Scanner(myObj)) {
                node = fileManager.nextInt();
                edge = fileManager.nextInt();

                graph = new int[node][node];
                for (int i = 0; i < edge; i++) {
                    int edge_a = fileManager.nextInt();
                    int edge_b = fileManager.nextInt();
                    graph[edge_a][edge_b] = 1;
                    graph[edge_b][edge_a] = 1;
                }
                s = fileManager.nextInt();
                fileManager.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("\"bfs.txt\" file not found in your Desktop forder");
            System.exit(0);
        }
        System.out.println("The graph is:");

        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        // visited and level array
        vis = new int[node];
        lev = new int[node];
        par = new int[node];

        for (int i = 0; i < node; i++) // initialize the visited and level array
        {
            vis[i] = 0; // white
            lev[i] = 999999; // infinite
            par[i] = -1;
        }
//        int s = 0; // source node
        vis[s] = 1; // gray
        lev[s] = 0;

        Queue<Integer> q = new LinkedList<>();

        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll(); // this will work as parent node
            for (int v = 0; v < node; v++) {
                if (graph[u][v] == 1 && vis[v] == 0) // visit the child nodes v
                {
                    vis[v] = 1;
                    lev[v] = lev[u] + 1;
                    par[v] = u;
                    q.add(v);
                }
            }
            vis[u] = 2;
        }
        for (int i = 0; i < node; i++) {
            System.out.println("Node = " + i + " Level = " + lev[i]);
        }
        System.out.println("");
        for (int i = 0; i < node; i++) {
            System.out.println("parent of " + i + " is: " + (par[i] == -1 ? "this is source" : par[i]));
        }
    }

}

public class Bfs {

    public static void main(String[] args) {
        // TODO code application logic here
        new BFS();
    }

}
