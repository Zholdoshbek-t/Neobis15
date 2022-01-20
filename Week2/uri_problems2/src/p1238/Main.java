package p1238;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        sc.nextLine();
        for (int k = 0; k < tests; k++) {
            Scanner input = new Scanner(sc.nextLine());
            String a = input.next();
            String b = input.next();
            if (a.length() <= b.length()) {
                combine(a, b, a.length(), 0);
            } else {
                combine(a, b, b.length(), 1);
            }
        }
    }

    public static void combine(String a, String b, int l, int smaller) {
        String result = "";
        for (int i = 0; i < l; i++) {
            result += a.charAt(i);
            result += b.charAt(i);
        }
        if (smaller == 0) {
            result += b.substring(a.length());
        } else if (smaller == 1) {
            result += a.substring(b.length());
        }
        System.out.println(result);
    }

}