package p2048;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] table = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                table[i][k] = scan.nextInt();
            }
        }
        int operation = scan.nextInt();
        switch (operation) {
            case 0:
                left(table);
                break;
            case 1:
                up(table);
                break;
            case 2:
                right(table);
                break;
            case 3:
                down(table);
                break;
        }
        display(table);
    }

    public static void left(int[][] nums) {
        for (int[] array : nums) {
            int[] duplicate = fill(merge(array, 0), 0);
            for (int i = 0; i < array.length; i++) {
                array[i] = duplicate[i];
            }
        }
    }

    public static void right(int[][] nums) {
        for (int[] array : nums) {
            int[] duplicate = fill(merge(array, 1), 2);
            for (int i = 0; i < array.length; i++) {
                array[i] = duplicate[i];
            }
        }
    }

    public static void up(int[][] nums) {

        for (int i = 0; i < 4; i++) {
            int[] v = new int[4];
            for (int k = 0; k < 4; k++) {
                v[k] = nums[k][i];
            }
            int[] duplicate = fill(merge(v, 0), 1);
            for (int j = 0; j < v.length; j++) {
                v[j] = duplicate[j];
            }
            for (int k = 0; k < 4; k++) {
                nums[k][i] = v[k];
            }
        }
    }

    public static void down(int[][] nums) {

        for (int i = 0; i < 4; i++) {
            int[] v = new int[4];
            for (int k = 0; k < 4; k++) {
                v[k] = nums[k][i];
            }
            int[] duplicate = fill(merge(v, 1), 3);
            for (int j = 0; j < v.length; j++) {
                v[j] = duplicate[j];
            }
            for (int k = 0; k < 4; k++) {
                nums[k][i] = v[k];
            }
        }
    }

    public static int[] merge(int[] arr, int d) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) { // change merge on right side
            if (i != 0) {
                list.add(i);
            }
        }
        if (d == 0) {
            for (int i = 0; i < list.size() - 1; i++) {
                int a = list.get(i);
                int b = list.get(i + 1);
                if (a == b) {
                    list.remove(i);
                    list.remove(i);
                    list.add(i, a + b);
                }
            }
        } else if (d == 1) {
            Collections.reverse(list);
            for (int i = 0; i < list.size() - 1; i++) {
                int a = list.get(i);
                int b = list.get(i + 1);
                if (a == b) {
                    list.remove(i);
                    list.remove(i);
                    list.add(i, a + b);
                }
            }
            Collections.reverse(list);
        }
        int[] newArr = new int[list.size()];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = list.get(i);
        }
        return newArr;
    }

    public static int[] fill(int[] arr, int d) {
        if (arr.length < 4) {
            int[] newArr = new int[4];
            if (d == 0 || d == 1) { // left up
                for (int i = 0; i < 4; i++) {
                    if (i >= arr.length) {
                        newArr[i] = 0;
                    } else {
                        newArr[i] = arr[i];
                    }
                }
            } else if (d == 2 || d == 3) { // right down
                for (int i = 0; i < 4 - arr.length; i++) {
                    newArr[i] = 0; // 2048 64
                }
                int c = 0;
                for (int i = 4 - arr.length; i < 4; i++) {
                    newArr[i] = arr[c];
                    c++;
                }
            }
            arr = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = newArr[i];
            }
        }
        return arr;
    }

    public static void display(int[][] arr) {
        for (int[] i : arr) {
            for (int k = 0; k < 4; k++) {
                System.out.print(k != 3 ? i[k] + " " : i[k]);
            }
            System.out.println();
        }
    }

}