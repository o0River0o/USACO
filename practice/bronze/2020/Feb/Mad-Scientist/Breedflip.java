
/***********************************
 *
 * Problem: Mad Scientist
 * Date: 2020-9-26
 * Author: Terry Gu
 *
 ***********************************/

/**
   Farmer John 当前正面对一个有关她的奶牛们的独特而不寻常的问题。他最近订购了 N 头奶牛（1≤N≤1000），
   包含两种不同品种：荷斯坦牛和更赛牛。他在订单中用一个长为 N 的字符串来指定奶牛，其中的字符为 H（表示荷斯坦牛）或 G（表示更赛牛）。
   不幸的是，当这些奶牛到达他的农场，他给她们排队时，她们的品种组成的字符串与原先的不同。
*/

import java.io.*;

class Breedflip {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));

        int n = Integer.parseInt(br.readLine());
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        br.close();

        boolean mismatch = false;
        int res = 0;

        for (int i = 0; i < n; ++i) {
            if(a[i] != b[i]) {
                if(!mismatch) {
                    mismatch = true;
                    res++;
                }
            }else {
                mismatch = false;
            }
        }

        pw.print(res);
        pw.close();
    }
}