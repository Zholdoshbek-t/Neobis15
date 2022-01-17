package p1045.LogicalSequence2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int line = 0;
        for (int i = 1; i <= b; i++) {
            line++;
            if(line == a) {
                System.out.print(i + "\n");
                line = 0;
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
