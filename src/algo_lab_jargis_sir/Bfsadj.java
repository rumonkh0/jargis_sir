package algo_lab_jargis_sir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author rumon
 */
public class Bfsadj {

    static int node, edge;
    static LinkedList<Integer> adj[];
    static String color[];

    Bfsadj(int v) {
        node = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void travarse(int source) {
        boolean flag = true;
        Queue<Integer> q = new LinkedList<>();
        color = new String[node];
        int parent[] = new int[node];
        for (int i = 0; i < node; i++) {
            color[i] = "white";
            parent[i] = -1;
        }
        q.add(source);
        color[source] = "gray";
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u);
            for (int v : adj[u]) {
                if (color[v].equals("white")) {
                    color[v] = "gray";
                    parent[v] = u;
                    q.add(v);
                } else if (!color[v].equals("white") && parent[v] != u) {
                    flag = false;
                }

            }
            if (!q.isEmpty()) {
                System.out.print("-->");
            }
            color[u] = "black";
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        node = sc.nextInt();
//        edge = sc.nextInt();

//        for (int i = 0; i < edge; i++) {
//            int j = sc.nextInt();
//            int k = sc.nextInt();
//            g.addEdge(j, k);
//        }
//        int s;
//        s = sc.nextInt();
//        g.travarse(s);
        try {
//            File myObj = new File("bfs.txt");
            File myObj = new File(System.getProperty("user.home") + File.separator +"Desktop"+File.separator+"bfs.txt");
            try (Scanner fileManager = new Scanner(myObj)) {
                node = fileManager.nextInt();
                edge = fileManager.nextInt();
                Bfsadj g = new Bfsadj(node);
                for (int i = 0; i < edge; i++) {
                    int edge_a = fileManager.nextInt();
                    int edge_b = fileManager.nextInt();
                    g.addEdge(edge_a, edge_b);
                }
                int source = fileManager.nextInt();
                g.travarse(source);
                fileManager.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("\"bfs.txt\" file not found in your Desktop forder\"");
            System.exit(0);
        }
    }
}
