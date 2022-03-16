package p1047;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int f = a * 60 + b;
        int s = c * 60 + d;
        int r = s - f;
        int h, m;
        if (r > 0) {
            h = r / 60;
            r -= 60 * h;
            m = r;
        } else {
            r = (24 * 60) - f + s;
            h = r / 60;
            r -= 60 * h;
            m = r;
        }
        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n", h, m);
    }
}
