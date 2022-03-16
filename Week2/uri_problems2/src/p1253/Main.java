package p1253;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alphabetArr = alphabet.toCharArray();
        int test = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < test; i++) {
            String word = sc.nextLine();
            String newWord = "";
            int shift = sc.nextInt();
            sc.nextLine();
            for (char c: word.toCharArray()) {
                int index = alphabet.indexOf(c) - shift;
                if (index < 0) {
                    index = 26 - Math.abs(index);
                }
                newWord += alphabetArr[index];
            }
            System.out.println(newWord);
        }
    }

}