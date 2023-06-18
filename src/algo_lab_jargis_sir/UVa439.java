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
public final class UVa439 {

    static int dim, graph[][], color[][], count = 0, image = 0;
    static String s = "";

    static void input(Scanner bfs_scanner) {
        dim = Integer.parseInt(bfs_scanner.nextLine());
        graph = new int[dim][dim];
        color = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            String line = bfs_scanner.nextLine();
            for (int j = 0; j < dim; j++) {
                graph[i][j] = Character.getNumericValue(line.charAt(j));
                color[i][j] = 0;
            }
        }
    }

    static void DFS_travarse(int i, int j) {

        //check if the pixel not out of bound and travarse
        if ((i >= 0 && i < dim) && (j >= 0 && j < dim)) {
            if (graph[i][j] == 1 && color[i][j] == 0) // visit the child nodes v
            {
                //mark as discovered
                color[i][j] = 1;

                //travarse all 8 sites of the pixel and 
                DFS_travarse(i - 1, j);
                DFS_travarse(i - 1, j + 1);
                DFS_travarse(i - 1, j - 1);
                DFS_travarse(i + 1, j);
                DFS_travarse(i + 1, j + 1);
                DFS_travarse(i + 1, j - 1);
                DFS_travarse(i, j + 1);
                DFS_travarse(i, j - 1);

                //mark as visited
                color[i][j] = 2;
            }
        }

    }

    public static void main(String[] args) {
        try {
//            File bfsfile = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "uva439.txt");
            File bfsfile = new File("input.txt");
            try (Scanner bfs_scanner = new Scanner(bfsfile)) {
                while (bfs_scanner.hasNextLine()) {
                    // input a portion of inputs
                    input(bfs_scanner);
                    for (int i = 0; i < dim; i++) {
                        for (int j = 0; j < dim; j++) {
                            if (color[i][j] == 0 && graph[i][j] == 1) {
                                DFS_travarse(i, j);
                                count++;
                            }
                        }
                    }
                    image++;
                    s = s + "Image number " + image + " contains " + count + " war eagles.\n";
//                    System.out.println("Image number " + image + " contains " + count + " war eagles.");
                    count = 0;
                }
                bfs_scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("\"uva439.txt\" file not found in your Desktop forder");
            System.exit(0);
        }

        //output file as a tex file
        try {
            try (FileWriter myWriter = new FileWriter("output.txt")) {
                myWriter.write(s);
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred with file writing.");
        }
    }
}
