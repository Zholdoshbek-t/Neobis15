package p1021;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int[] banknotes = {100, 50, 20, 10, 5, 2};
        int[] occurs = new int[banknotes.length];
        double numD = scan.nextDouble();
        String strNum = String.valueOf(numD);
        int num2 = Integer.parseInt(strNum.substring(strNum.indexOf(".") + 1));
        int num = (int) numD;
        for (int i = 0; i < banknotes.length; i++) {
            int times = num / banknotes[i];
            if (times != 0) {
                num -= (times * banknotes[i]);
            }
            occurs[i] = times;
        }
        System.out.println("NOTAS:");
        for (int i = 0; i < banknotes.length; i++) {
            System.out.printf("%d nota(s) de R$ %d.00%n", occurs[i], banknotes[i]);
        }
        double[] banknotes2 = {1.00, 0.50, 0.25, 0.10, 0.05, 0.01};
        int[] occurs2 = new int[banknotes2.length];
        for (int i = 1; i < banknotes2.length; i++) {
            int times = num2 / (int) (banknotes2[i] * 100);
            if (times != 0) {
                num2 -= (times * (100 * banknotes2[i]));
            }
            occurs2[i] = times;
        }
        if (num == 1) {
            occurs2[0] = 1;
        }
        System.out.println("MOEDAS:");
        for (int i = 0; i < banknotes.length; i++) {
            System.out.printf("%d moeda(s) de R$ %.2f%n", occurs2[i], banknotes2[i]);
        }
    }
}