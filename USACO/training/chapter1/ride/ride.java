
/*
ID: *******
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ride.in"));
        PrintWriter pt = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        
        StringTokenizer cometName = new StringTokenizer(br.readLine());
        StringTokenizer groupName = new StringTokenizer(br.readLine());

        String cometChar = cometName.nextToken();
        String groupChar = groupName.nextToken();
        int cometProd = 1, 
            groupProd = 1;

        for(Character c : cometChar.toCharArray()) {
            // System.out.println(c);
            // System.out.println((int)c - (int)'A' + 1);
            cometProd *= (int)c - (int)'A' + 1;
        }

        for(Character c : groupChar.toCharArray()) {
            // System.out.println(c);
            // System.out.println((int)c - (int)'A' + 1);
            groupProd *= (int)c - (int)'A' + 1;
        }

        // System.out.println(cometProd);
        // System.out.println(groupProd);

        cometProd %= 47;
        groupProd %= 47;

        // System.out.println(cometProd);
        // System.out.println(groupProd);
        // System.out.println(cometProd == groupProd);

        if(cometProd == groupProd) {
            // System.out.println("GO");
            pt.println("GO");
        }else{
            // System.out.println("STAY");
            pt.println("STAY");
        }

        br.close();
        pt.close();

    }
}