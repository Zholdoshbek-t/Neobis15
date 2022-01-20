package p1164;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int n = sc.nextInt();
            int sum = 0;
            for (int k = 1; k < n; k++) {
                if (n % k == 0) {
                    sum += k;
                }
            }
            if (sum == n) {
                System.out.println(n + " eh perfeito");
            } else {
                System.out.println(n + " nao eh perfeito");
            }
        }
    }

}