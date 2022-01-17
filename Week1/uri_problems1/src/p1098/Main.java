package p1098;

public class Main {
    public static void main(String[] args) {
        double i = 0;
        while (i <= 2.0) {
            if(i == 0 || i == 1 || (int)((i + 0.1) / 2) == 1) {
                for (int j = 1; j <= 3; j++) {
                    System.out.printf("I=%.0f J=%.0f%n", i, j + i);
                }
            } else {
                for (int j = 1; j <= 3; j++) {
                    System.out.printf("I=%.1f J=%.1f%n", i, j + i);
                }
            }
            i += 0.2;
        }
    }
}
