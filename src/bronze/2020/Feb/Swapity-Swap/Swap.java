
/***********************************
 *
 * Problem: Swapity Swap
 * Date: 2020-8-24
 * Author: Terry Gu
 *
 ***********************************/
 
/**
 * Farmer John has come up with a new morning exercise routine for the cows. He tells them to repeat the following two-step process exactly K (1≤K≤109) times:

    The sequence of cows currently in positions A1…A2 from the left reverse their order (1≤A1<A2≤N).
    Then, the sequence of cows currently in positions B1…B2 from the left reverse their order (1≤B1<B2≤N).
    After the cows have repeated this process exactly K times, please output the label of the ith cow from the left for each 1≤i≤N.

    SCORING:
    Test cases 2-3 satisfy K≤100.
    Test cases 4-13 satisfy no additional constraints.

    INPUT FORMAT (file swap.in):
    The first line of input contains N and K. The second line contains A1 and A2, and the third contains B1 and B2.

    OUTPUT FORMAT (file swap.out):
    On the ith line of output, print the label of the ith cow from the left at the end of the exercise routine.
 */

import java.io.*;
import java.util.*;

public class Swap {
    public static void main(String[] args) throws IOException{
        //Read and Write files
        BufferedReader reader = new BufferedReader(new FileReader("swap.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        System.out.println("st: "+st);

        //read and define vars
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        int a1 = Integer.parseInt(st.nextToken()) - 1;
        int a2 = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(reader.readLine());
        int b1 = Integer.parseInt(st.nextToken()) - 1;
        int b2 = Integer.parseInt(st.nextToken()) - 1;
        reader.close();

        int cycleSize = 0;
        int[] l = new int[n];

        for (int i = 0; i < n; ++i) l[i] = i;
        boolean sorted = true;

        do{
            cycleSize++;
            reverse(l, a1, a2);
            reverse(l, b1, b2);
            sorted = true;

            for(int i = 0; sorted && i < n; i++) sorted = l[i] == i;
        }
        while(!sorted);

        k %= cycleSize;

        for(int i = 0; i < n; i++) l[i] = i + 1;
        for(int i = 0; i < k; i++) {
            reverse(l, a1, a2);
            reverse(l, b1, b2);
        }

        for(int val : l) writer.println(val);
        writer.close();
    }

    private static void reverse(int[] l, int a, int b) {
        while (a < b) {
            int t = l[a];
            l[a] = l[b];
            l[b] = t;
            a++;
            b--;
        }
    }
}