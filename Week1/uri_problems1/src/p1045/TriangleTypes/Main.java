package p1045.TriangleTypes;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] nums = new double[3];
        for (int i = 0; i < 3; i++) { nums[i] = scan.nextDouble(); }
        Arrays.sort(nums);
        double a = nums[2];
        double b = nums[1];
        double c = nums[0];
        double aSq = a * a;
        double bcSq = b * b + c * c;
        if(a >= b + c) {
            System.out.println("NAO FORMA TRIANGULO");
        } else {
            if (aSq == bcSq) {
                System.out.println("TRIANGULO RETANGULO");
            }
            if (aSq > bcSq) {
                System.out.println("TRIANGULO OBTUSANGULO");
            }
            if (aSq < bcSq) {
                System.out.println("TRIANGULO ACUTANGULO");
            }
            if (a == b && b == c) {
                System.out.println("TRIANGULO EQUILATERO");
            }
            if ((a == b && b != c) || (a == c && c != b) || (b == c && c != a)) {
                System.out.println("TRIANGULO ISOSCELES");
            }
        }
    }
}
