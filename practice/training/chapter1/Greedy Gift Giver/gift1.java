/*
ID: gyoushi1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter outf = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        StringTokenizer st;

        int np = Integer.parseInt(f.readLine());
        String[] names = new String[np];
        HashMap<String, Integer> money = new HashMap<String, Integer>();
        for (int i = 0; i < np; i++) {
            names[i] = f.readLine();
            money.put(names[i], 0);
        }

        for (int i = 0; i < np; i++) {
            String name = f.readLine();
            st = new StringTokenizer(f.readLine());
            int amount = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            if (amount != 0 && people != 0) {
                int give = amount / people;
                for (int j = 0; j < people; j++) {
                    String receiver = f.readLine();
                    money.put(receiver, money.get(receiver) + give);
                    money.put(name, money.get(name) - give);
                }
            }

            else if (people != 0) {
                for (int j = 0; j < people; j++) {
                    f.readLine();
                }
            }
        }

        for (String n : names)
            outf.println(n + " " + money.get(n));

        f.close();
        outf.close();
        System.exit(0);
    }
}