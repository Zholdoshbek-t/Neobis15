package p1160;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            double ad = scan.nextDouble();
            double bd = scan.nextDouble();
            int anos = 1;
            while (true) {
                double addA = a * (ad / 100.0);
                if (addA / (int) addA == 1) {
                    a += addA;
                } else {
                    a += (int) addA;
                }
                double addB = b * (bd / 100.0);
                if (addB / (int) addB == 1) {
                    b += addB;
                } else {
                    b += (int) addB;
                }
                if(a > b) {
                    break;
                }
                anos++;
            }
            System.out.println(anos > 100 ? "Mais de 1 seculo." : anos + " anos.");
        }
    }
}
