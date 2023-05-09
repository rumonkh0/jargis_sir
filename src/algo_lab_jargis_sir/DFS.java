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
public final class DFS {
    
    int node, edge, graph[][], color[], prev[], d[], f[], time, start, end;
    
    DFS() {
        try {
//            File bfsfile = new File("bfs.txt");
            File bfsfile = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "bfs.txt");
            try (Scanner bfs_scanner = new Scanner(bfsfile)) {
                node = bfs_scanner.nextInt();
                edge = bfs_scanner.nextInt();
                
                graph = new int[node][node];
                for (int i = 0; i < edge; i++) {
                    int edge_a = bfs_scanner.nextInt();
                    int edge_b = bfs_scanner.nextInt();
                    graph[edge_a][edge_b] = 1;
                    graph[edge_b][edge_a] = 1;
                }
//                start = bfs_scanner.nextInt();
                bfs_scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("\"bfs.txt\" file not found in your Desktop forder");
            System.exit(0);
        }
        
        color = new int[node];
        prev = new int[node];
        d = new int[node];
        f = new int[node];
        
        for (int i = 0; i < node; i++) // initialize the visited and level array
        {
            color[i] = 0; // white
            prev[i] = -1; // infinite
            f[i] = 999999999;
            d[i] = 999999999;
        }
        time = 0;
        for (int i = 0; i < node; i++) {
            if (color[i] == 0) {
                DFS_travarse(i);
            }
        }
    }
    
    void DFS_travarse(int u) {
        color[u] = 1;
        time++;
        d[u] = time;
        for (int v = 0; v < node; v++) {
            if (graph[u][v] == 1 && color[v] == 0) // visit the child nodes v
            {
                prev[v] = u;
                DFS_travarse(v);
            }
        }
        color[u] = 2;
        System.out.print(u+"-->");
        time++;
        f[u] = time;
    }
    public static void main(String[] args) {
        new DFS();
    }
    
}
