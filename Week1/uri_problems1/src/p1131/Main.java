package p1131;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int games = 0;
        int inter = 0;
        int gremio = 0;
        int empates = 0;
        while (true) {
            games++;
            System.out.println("Novo grenal (1-sim 2-nao)");
            int a = scan.nextInt();
            int b = scan.nextInt();
            if(a > b) {
                inter++;
            } else if(b > a) {
                gremio++;
            } else {
                empates++;
            }
            int operation = scan.nextInt();
            if(operation != 1) {
                break;
            }
        }
        System.out.println(games + " grenais");
        System.out.println("Inter:" + inter);
        System.out.println("Gremio:" + gremio);
        System.out.println("Empates:" + empates);
        System.out.println(inter > gremio ? "Inter venceu mais" : inter < gremio ? "Gremio venceu mais" : "Não houve vencedor");
    }
}
