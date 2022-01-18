package p1237;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int longest = 0;
            for (int i = 0; i < a.length(); i++) {
                for (int k = i; k <= a.length(); k++) {
                    if (b.contains(a.substring(i, k))) {
                        if (k - i > longest) {
                            longest = k - i;
                        }
                    }
                }
            }
            System.out.println(longest);
        }
    }

}