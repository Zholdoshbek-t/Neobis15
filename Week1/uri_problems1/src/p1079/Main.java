package p1079;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            double a = scanner.nextDouble() * 2;
            double b = scanner.nextDouble() * 3;
            double c = scanner.nextDouble() * 5;
            double average = (a + b + c) / 10;
            System.out.printf("%.1f%n", average);
        }
    }
}
