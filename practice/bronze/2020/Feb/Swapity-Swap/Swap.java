
/***********************************
 *
 * Problem: Swapity Swap
 * Date: 2020-8-24
 * Author: Terry Gu
 *
 ***********************************/
 
/**
   Farmer John 的 N 头奶牛（1≤N≤100）站成一排。对于每一个 1≤i≤N，从左往右数第 i 头奶牛的编号为 i。
   Farmer John 想到了一个新的奶牛晨练方案。他让她们重复以下包含两个步骤的过程 K（1≤K≤109）次：

   当前从左往右数在位置 A1…A2 的奶牛序列反转她们的顺序（1≤A1<A2≤N）。
   然后，在当前从左往右数在位置 B1…B2 的奶牛序列反转她们的顺序（1≤B1<B2≤N）。
   当奶牛们重复这一过程 K 次后，请对每一个 1≤i≤N 输出从左往右数第 i 头奶牛的编号。
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