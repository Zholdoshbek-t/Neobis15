package p1165;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        for (int i = 0; i < test; i++) {
            int n = scan.nextInt();
            boolean primo = true;
            for (int k = 2; k <= n / 2; k++) {
                if (n % k == 0) {
                    primo = false;
                    break;
                }
            }
            if (primo) {
                System.out.println(n + " eh primo");
            } else {
                System.out.println(n + " nao eh primo");
            }
        }
    }

}