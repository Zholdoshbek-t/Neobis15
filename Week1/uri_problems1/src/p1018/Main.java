package p1018;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int[] banknotes = {100, 50, 20, 10, 5, 2, 1};
        int[] occurs = new int[banknotes.length];
        int num = scan.nextInt();
        int duplicate = num;
        for (int i = 0; i < banknotes.length; i++) {
            int times = num / banknotes[i];
            if (times != 0) {
                num -= (times * banknotes[i]);
            }
            occurs[i] = times;
        }
        System.out.println(duplicate);
        for (int i = 0; i < banknotes.length; i++) {
            System.out.printf("%d nota(s) de R$ %d,00%n", occurs[i], banknotes[i]);
        }
    }

}