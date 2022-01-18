package p2242;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder r = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                r.append(c);
            }
        }
        if(r.toString().equals(r.reverse().toString())) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }
    }

}