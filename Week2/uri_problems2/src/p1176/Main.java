package p1176;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Long[] arr = new Long[61];
        arr[0] = 0L;
        arr[1] = 1L;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        int test = scan.nextInt();
        for (int i = 0; i < test; i++) {
            int index = scan.nextInt();
            System.out.printf("Fib(%d) = %d%n", index, arr[index]);
        }
    }

}