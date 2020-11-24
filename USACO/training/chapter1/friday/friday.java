/*
ID: *******
LANG: JAVA
TASK: friday
*/

import java.io.*;

class friday {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("friday.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

    int n = Integer.parseInt(br.readLine());
    br.close();
    
    int[] counts = new int[7];
    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int beginDay = 1;
    for(int i = 0; i < n; i++) {
      int year = 1900 + i;
      boolean isLeap = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

      if(isLeap) {
        days[1] = 29;
      }else {
        days[1] = 28;
      }

      int res = 0;

      for(int day : days) {
        int weekDay = (beginDay + res + 12) % 7;
        counts[weekDay]++;
        res += day;
      }

      beginDay = (beginDay + res) % 7;

    }

    int N = 6;
    while(N != 5) {
      // System.out.println(N);
      pw.print(counts[N] + " ");
      if(N == 6) {
        N = 0;
      }else {
        N++;
      }
    }
    pw.print(counts[5] + "\n");

    pw.close();
  }

}
