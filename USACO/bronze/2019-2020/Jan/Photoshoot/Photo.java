/***********************************
 *
 * Problem: Photoshoot
 * Date: 2020-9-28
 * Author: Terry Gu
 *
 ***********************************/

 /**
  Farmer John is lining up his N cows (2≤N≤103), numbered 1…N, for a photoshoot. FJ initially planned for the i-th cow from the left to be the cow numbered ai, and wrote down the permutation a1,a2,…,aN on a sheet of paper. Unfortunately, that paper was recently stolen by Farmer Nhoj!
  Luckily, it might still possible for FJ to recover the permutation that he originally wrote down. Before the sheet was stolen, Bessie recorded the sequence b1,b2,…,bN−1 that satisfies bi=ai+ai+1 for each 1≤i<N.
  
  Based on Bessie's information, help FJ restore the "lexicographically minimum" permutation a that could have produced b. A permutation x is lexicographically smaller than a permutation y if for some j, xi=yi for all i<j and xj<yj (in other words, the two permutations are identical up to a certain point, at which x is smaller than y). It is guaranteed that at least one such a exists.
  
  SCORING:
  Test cases 2-4 satisfy N≤8.
  Test cases 5-10 satisfy no additional constraints.

  INPUT FORMAT (file photo.in):
  The first line of input contains a single integer N.
  The second line contains N−1 space-separated integers b1,b2,…,bN−1.
  
  OUTPUT FORMAT (file photo.out):
  A single line with N space-separated integers a1,a2,…,aN.
  */

import java.io.*;
import java.util.*;

class Photo {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new FileReader("photo.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[] sums = new int[n - 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n - 1; i++){
      sums[i] = Integer.parseInt(st.nextToken());
    }

    int[] perm = new int[n];

    // Try each item as the first.
    for (int first = 1; first < sums[0]; first++) {
      perm[0] = first;

      // These are all forced.
      for (int i = 1; i < n; i++)
        perm[i] = sums[i - 1] - perm[i - 1];

      // Good as long as it's a permutation!
      if (isPerm(perm))
        break;
    }

    // Output result.
    for (int i = 0; i < n - 1; i++) {
      pw.print(perm[i] + " ");
    }

    pw.println(perm[n - 1]);
    pw.close();
    br.close();
  }

  // Returns true iff perm stores a permutation of 1..perm.length.
  public static boolean isPerm(int[] perm) {

    int n = perm.length;

    // Store how many of each item is here.
    int[] freq = new int[n];
    for (int i = 0; i < n; i++) {

      // Screen out things that are out of bounds.
      if (perm[i] < 1 || perm[i] > n)
        return false;

      // Safe to do this.
      freq[perm[i] - 1]++;

      // Oops we have a repeat.
      if (freq[perm[i] - 1] > 1)
        return false;
    }

    // If we get here it has to be a perm.
    return true;
  }
}
