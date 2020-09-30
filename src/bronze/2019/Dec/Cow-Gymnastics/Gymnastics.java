/***********************************
 *
 * Problem: Cow Gymnastics
 * Date: 2020-9-28
 * Author: Terry Gu
 *
 ***********************************/

 /**
  * In order to improve their physical fitness, the cows have taken up gymnastics! Farmer John designates his favorite cow Bessie to coach the N other cows and to assess their progress as they learn various gymnastic skills.
  In each of K practice sessions (1≤K≤10), Bessie ranks the N cows according to their performance (1≤N≤20). Afterward, she is curious about the consistency in these rankings. A pair of two distinct cows is consistent if one cow did better than the other one in every practice session.
  
  Help Bessie compute the total number of consistent pairs.
  */

import java.io.*;
import java.util.*;

public class Gymnastics {
  private static int N,K;
  private static int[][] data = new int[10][20]; // int[0 <= K <= 10][0 <= N <= 20]

  static boolean isBetter(int a, int b, int ses) {
    int apos = 0, bpos = 0;
    for(int i = 0; i < N; ++i) {
      if(data[ses][i] == a) apos = i;
      if(data[ses][i] == b) bpos = i;
    }

    return apos < bpos;
  }

  static int better(int a, int b) {
    int total = 0;
    for(int i = 0; i < K; ++i)
      if(isBetter(a, b, i)) total++;

    return total;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());

    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    System.out.println(K + ":" + N);

    for(int i = 0; i <= K; ++i) {
      System.out.println(i);
      String line = br.readLine();
      if(line != null) {
        st = new StringTokenizer(line);
        for (int j = 0; j < N; ++j) {
          System.out.println(j);
          data[i][j] = Integer.parseInt(st.nextToken());
          System.out.println("data["+i+"]"+"["+j+"]: " + data[i][j]);
        }
      }else {
        break;
      }
    }
    br.close();

    int res = 0;
    for(int a = 1; a <= N; ++a){
      for(int b = 1; b <= N; ++b){
        if(better(a,b) == K) res++;
        System.out.println(a + ":" + b);
      }
    }

    pw.println(res);
    pw.close();
  }
}
