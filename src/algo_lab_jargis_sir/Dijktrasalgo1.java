
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Dijktrasalgo1 {

    public static void printDij(int graph[][], int dis[], int v) {

        for (int i = 0; i < v; i++) {

            System.out.println(i + "->" + "=" + dis[i]);

        }

    }

    public static int minSet(int dis[], boolean sptSet[], int v) {

        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < v; i++) {

            if (!sptSet[i] && dis[i] <= min) {

                min = dis[i];
                index = i;
            }

        }

        return index;
    }

    void dijktrasAlgo(int graph[][], int v, int sr) {
        int dis[] = new int[v];
        boolean sptSet[] = new boolean[v];

        for (int i = 0; i < v; i++) {

            dis[i] = Integer.MAX_VALUE;

            sptSet[i] = false;
        }

        dis[sr] = 0;
        sptSet[sr] = true;
        for (int c = 0; c < v - 1; c++) {

            int u = minSet(dis, sptSet, v);
            System.out.println(u);
            sptSet[u] = true;
            for (int i = 0; i < v; i++) {
//                System.out.println(!sptSet[i]);
//                System.out.println(graph[u][i]);
                System.out.println(dis[u]);
//                System.out.println(graph[u][i]);
//                System.out.println(dis[i]);
                if (!sptSet[i] && graph[u][i] != 0 && dis[u] != Integer.MAX_VALUE && dis[u] + graph[u][i] < dis[i])                  {
                    dis[i] = dis[u] + graph[u][i];
                }

            }

        }
        printDij(graph, dis, v);

    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/rumon/Desktop/prims.txt");
        Scanner fr = new Scanner(file);
        int v, e;
        v = fr.nextInt();
        e = fr.nextInt();
        int graph[][] = new int[v][v];

        for (int i = 0; i < e; i++) {

            int s, d, w;
            s = fr.nextInt();
            d = fr.nextInt();
            w = fr.nextInt();
            graph[s][d] = w;
            graph[d][s] = w;

        }
        int sr = fr.nextInt();
        Dijktrasalgo1 t = new Dijktrasalgo1();
        t.dijktrasAlgo(graph, v, sr);
    }
}
