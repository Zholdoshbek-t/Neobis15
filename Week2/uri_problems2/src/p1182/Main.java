package p1182;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int column = sc.nextInt();
        sc.nextLine();
        String operation = sc.nextLine();
        double[][] table = new double[12][12];
        for (int i = 0; i < 12; i++) {
            for (int k = 0; k < 12; k++) {
                table[i][k] = sc.nextDouble();
            }
        }
        double sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += table[i][column];
        }
        if (operation.equals("S")) {
            System.out.printf("%.1f%n", sum);
        } else {
            System.out.printf("%.1f%n", sum / 12.0);
        }
    }
}