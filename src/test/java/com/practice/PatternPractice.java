package com.practice;

import java.util.Scanner;

public class PatternPractice {

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

//        printSquareStarPattern();
//        printSquareNumberPattern();
//        printHallowSquarePattern();
//        printHallowSquareNumbers();
//        printNumberPattern();
//        printNumberPattern2();
//        printNumberPattern3();
//        printRightTraiangle();
//        printRightTraiangleNum();
//        printRightTraiangleCount();
//        printReverseRightAngleTraiangle();
//        printPyramid();
//        printRightAngleTranglewithSpaces();
//        printHallowPyramid();
//        printReverseRightAngleTraiangle2();
//        printReversePyramid();
//        printDoublePyramidPattern();
//        symatericPattern();
//        zeroOneRightAngleTrianglePattern();
        printPattern();
    }

    /*  OUTPUT for n=5
     * * * * *
     * * * * *
     * * * * *
     * * * * *
     * * * * *
     */
    public static void printSquareStarPattern() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
        1 1 1 1 1
        2 2 2 2 2
        3 3 3 3 3
        4 4 4 4 4
        5 5 5 5 5
    */
    public static void printSquareNumberPattern() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
     *****
     *   *
     *   *
     *   *
     *****
     */
    public static void printHallowSquarePattern() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
        11111
        2   2
        3   3
        4   4
        55555
    */
    public static void printHallowSquareNumbers() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n)
                    System.out.print(i);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
        01 02 03 04 05
        06 07 08 09 10
        11 12 13 14 15
        16 17 18 19 20
        21 22 23 24 25
    */
    public static void printNumberPattern() {
        int n = scan.nextInt();
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (count < 10)
                    System.out.print("0");
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
        01 02 03 04 05
        02 04 06 08 10
        03 06 09 12 15
        04 08 12 16 20
        05 10 15 20 25
    */
    public static void printNumberPattern2() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i * j < 10)
                    System.out.print("0");
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
        1 2 3 4 5
        2 3 4 5 6
        3 4 5 6 7
        4 5 6 7 8
        5 6 7 8 9
    */
    public static void printNumberPattern3() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i + j - 1 + " ");
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
     *
     * *
     * * *
     * * * *
     * * * * *
     */
    public static void printRightTraiangle() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
        1
        2 2
        3 3 3
        4 4 4 4
        5 5 5 5 5
    */
    public static void printRightTraiangleNum() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
        1
        2 3
        4 5 6
        7 8 9 10
        11 12 13 14 15
    */
    public static void printRightTraiangleCount() {
        int n = scan.nextInt();
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
     *
     **
     ***
     ****
     *****
     */
    public static void printReverseRightAngleTraiangle() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n - i; k++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
     *
     * *
     * * *
     * * * *
     * * * * *
     */
    public static void printPyramid() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n - i; k++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
     *
     **
     * *
     *  *
     *****
     */
    public static void printRightAngleTranglewithSpaces() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || i == n || i == j)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
     *
     * *
     *   *
     *     *
     * * * * *
     */
    public static void printHallowPyramid() {
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n - i; k++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++) {
                if (j == 1 || i == n || i == j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
     * * * * *
     * * * *
     * * *
     * *
     *
     */
    public static void printReverseRightAngleTraiangle2() {
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
     * * * * *
     * * * *
     * * *
     * *
     *
     */
    public static void printReversePyramid() {
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++)
                System.out.print(" ");
            for (int j = 0; j < n - i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
     *
     * *
     * * *
     * * * *
     * * * * *
     * * * *
     * * *
     * *
     *
     */
    public static void printDoublePyramidPattern() {
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n - i; k++)
                System.out.print(" ");
            for (int j = 0; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++)
                System.out.print(" ");
            for (int j = 0; j < n - i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    /*  OUTPUT for n=5
     *
     **
     ***
     ****
     *****
     ****
     ***
     **
     *
     */
    public static void symatericPattern() {
        int n = scan.nextInt();
        for (int i = 0; i <= 2 * n - 1; i++) {
            if (i > n) {
                for (int j = 0; j <= 2 * n - i; j++)
                    System.out.print("*");
            } else {
                for (int j = 0; j <= i; j++)
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    /* n=5
        1
        01
        101
        0101
        10101
    */
    public static void zeroOneRightAngleTrianglePattern() {
        int n = scan.nextInt();
        int start;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                start = 1;
            else
                start = 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }
    }

            /*
        Example Output for n = 5:

        1        1
        12      21
        123    321
        1234  4321
        1234554321
        */
    public static void  printPattern(){
        int n=scan.nextInt();
        int spaces=2*(n-1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int k=i;k<=spaces;k++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }

            System.out.println();
            spaces=spaces-2;

        }






    }
}
