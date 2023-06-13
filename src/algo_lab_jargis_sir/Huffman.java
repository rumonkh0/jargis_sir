/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algo_lab_jargis_sir;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author student_user
 */
class Node {

    int freq;
    char c;
    Node left;
    Node right;
}

class Hcomparator implements Comparator<Node> {

    public int compare(Node x, Node y) {
        return x.freq - y.freq;
    }
}

public class Huffman {

    static int size, freq[];
    static char arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        arr = new char[size];
        freq = new int[size];

        PriorityQueue<Node> q = new PriorityQueue<Node>(size, new Hcomparator());
        
        for (int i = 0; i < size; i++) {
            Node node = new Node();
            node.c = arr[i];
            node.freq = freq[i];

            node.left = null;
            node.right = null;

        }
        
        while(q.size()>1){
            Node x = q.poll();
            Node y = q.poll();
            
            Node n = new Node();
            n.c='-';
            n.freq = x.freq + y.freq;
            n.left = x;
            n.right = y;
            q.add(n);
        }
    }
}
