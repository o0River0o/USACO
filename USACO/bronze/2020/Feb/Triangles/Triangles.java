
/***********************************
 *
 * Problem: Triangles
 * Date: 2020-9-26
 * Author: Terry Gu
 *
 ***********************************/

/**
 *Farmer John would like to create a triangular pasture for his cows.
 * 
 *There are N fence posts (3≤N≤100) at distinct points (X1,Y1)…(XN,YN) on the 2D map of his farm. He can choose * three of them to form the vertices of the triangular pasture as long as one of the sides of the triangle is * * parallel to the x-axis and another side is parallel to the y-axis.
 * 
 * 
 * What is the maximum area of a pasture that Farmer John can form? It is guaranteed that at least one valid      triangular pasture exists.
 */

import java.io.*;
import java.util.*;

class Triangles{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));

    int n = Integer.parseInt(br.readLine());

    int[] x = new int[n];
    int[] y = new int[n];

    for(int i = 0; i < n; ++i) {
      StringTokenizer st =  new StringTokenizer(br.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }

    int res = 0;
    for(int i = 0; i < n; ++i) {
      for(int j = 0; j < n; ++j) {
        if(i == j || x[i] != x[j]) continue;

        for(int k = 0; k < n; ++k) {
          if(j == k || y[i] != y[k]) continue;
          res = Math.max(res, Math.abs(x[k] - x[i]) * Math.abs(y[j] - y[i]));
        }
      }
    }

    pw.print(res);

    br.close();
    pw.close();
  }
}
