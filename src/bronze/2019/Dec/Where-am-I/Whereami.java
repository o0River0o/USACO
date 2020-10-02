/***********************************
 *
 * Problem: Where am I
 * Date: 2020-9-30
 * Author: Terry Gu
 *
 ***********************************/

/*
  Along the road there are N farms (1≤N≤100) in a row. Farms unfortunately do not have house numbers, making it hard for Farmer John to figure out his location along the road. However, each farm does have a colorful mailbox along the side of the road, so Farmer John hopes that if he looks at the colors of the mailboxes nearest to him, he can uniquely determine where he is.

Each mailbox color is specified by a letter in the range A..Z, so the sequence of N mailboxes down the road can be represented by a string of length N containing letters in the range A..Z. Some mailboxes may have the same colors as other mailboxes. Farmer John wants to know what is the smallest value of K such that if he looks at any sequence of K consecutive mailboxes, he can uniquely determine the location of that sequence along the road.

For example, suppose the sequence of mailboxes along the road is 'ABCDABC'. Farmer John cannot set K=3, since if he sees 'ABC', there are two possible locations along the road where this consecutive set of colors might be. The smallest value of K that works is K=4, since if he looks at any consecutive set of 4 mailboxes, this sequence of colors uniquely determines his position along the road.
*/

import java.io.*;
import java.util.*;

class Whereami {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));

    int N = Integer.parseInt(br.readLine());
    //System.out.println(N);
    String S = br.readLine();
    //System.out.println(pos);
    br.close();
    
    int res = 1;
    boolean bad = false;

    Set<String> SS = new HashSet<>();

    for(int i = 1; i <= N; ++i) {
      if(!bad && i != 1)
        break;

      bad = false;

      for(int j = 0; j <= N-i; ++j) {
        String pos = S.substring(j,j+i);       
        //System.out.printf("(%d,%d): %d '%s'\n", i, j, res, pos);
        if(SS.contains(pos)) {
          bad = true;
          //System.out.println("************BAD************");
          res++;
          break;
        }

        SS.add(pos);
      }
    }
    
    System.out.println(res);
    pw.println(res);

    pw.close();

    //System.out.println(SS);
    //System.out.println(res + ":" + bad);
  }
}
