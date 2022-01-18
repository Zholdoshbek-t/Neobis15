package p2253;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.nextLine();
            if (s.length() < 6 || s.length() > 32) {
                System.out.println("Senha invalida.");
            } else {
                boolean hasNum = false;
                boolean hasUpcase = false;
                boolean hasLowcase = false;
                for (char c : s.toCharArray()) {
                    if (c >= 48 && c <= 57) {
                        hasNum = true;
                    } else if (c >= 65 && c <= 90) {
                        hasUpcase = true;
                    } else if (c >= 97 && c <= 122) {
                        hasLowcase = true;
                    } else {
                        hasNum = false;
                        break;
                    }
                }
                if (hasNum && hasUpcase && hasLowcase) {
                    System.out.println("Senha valida.");
                } else {
                    System.out.println("Senha invalida.");
                }
            }
        }
    }

}