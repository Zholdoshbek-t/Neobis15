package p1030;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();
        for (int k = 0; k < tests; k++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            ArrayList<Integer> circle = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                circle.add(i);
            }
            int steps = 1;
            int index = 0;
            while (circle.size() != 1) {
                steps++;
                index++;
                if (index >= circle.size()) {
                    index = index % circle.size();
                }
                if (steps == m) {
                    circle.remove(index);
                    steps = 1;
                }
            }
            System.out.printf("Case %d: %d%n", k + 1, circle.get(0));
        }
    }

}