package com.practice;

import java.util.Scanner;

public class PatternPractice {

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

//        pattern1();
//        pattern2();
//        pattern3();
//        pattern4();
//        pattern5();
//        pattern6();
//        pattern7();
//        pattern8();
//        pattern9();
//        pattern10();
//        pattern11();
//        pattern12();
//        pattern13();
//        pattern14();
//        pattern15();
//        pattern16();
//        pattern17();
//        pattern18();
//        pattern19();
//        pattern20();
//       pattern21();
//        pattern22();
//        pattern23();
//        pattern24();
//        pattern25();
        pattern26();
    }


    /*  OUTPUT for n=5
     * * * * *
     * * * * *
     * * * * *
     * * * * *
     * * * * *
     */
    public static void pattern1() {
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
    public static void pattern2() {
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
    public static void pattern3() {
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
    public static void pattern4() {
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
    public static void pattern5() {
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
    public static void pattern6() {
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
    public static void pattern7() {
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
    public static void pattern8() {
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
    public static void pattern9() {
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
    public static void pattern10() {
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
    public static void pattern11() {
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
    public static void pattern12() {
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
    public static void pattern13() {
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
    public static void pattern14() {
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
    public static void pattern15() {
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
    public static void pattern16() {
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
    public static void pattern17() {
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
    public static void pattern18() {
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
    public static void pattern19() {
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
        1        1
        12      21
        123    321
        1234  4321
        1234554321
    */
    public static void pattern20() {
        int n = scan.nextInt();
        int spaces = (n*2)-2;
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int k = 1; k <= spaces; k++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
            spaces = spaces - 2;
        }
    }

    /*
     **********
     ****  ****
     ***    ***
     **      **
     *        *
     */
    public static  void  pattern21(){
        int n=scan.nextInt();
        int space=0;
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            for(int k=1;k<=space;k++){
                System.out.print(" ");
            }
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
            space=space+2;
        }


    }
    /*
     *        *
     **      **
     ***    ***
     ****  ****
     **********
    */
    public static  void  pattern22() {
        int n = scan.nextInt();
        int spaces= (n*2)-2;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int k=1;k<=spaces;k++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
            spaces=spaces-2;
        }
    }
    /*
     **********
     ****  ****
     ***    ***
     **      **
     *        *
     *        *
     **      **
     ***    ***
     ****  ****
     **********
     */
    public static void pattern23(){
        int n=scan.nextInt();
        int spaces=0;
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            for(int k=1;k<=spaces;k++){
                System.out.print(" ");
            }
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
            spaces=spaces+2;
        }
        spaces=(n*2)-2;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int k=1;k<=spaces;k++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
            spaces=spaces-2;
        }


    }
    /*
     *        *
     **      **
     ***    ***
     ****  ****
     **********
     ****  ****
     ***    ***
     **      **
     *        *
     */ //striver
    public static  void  pattern24() {
        int n = scan.nextInt();
        int spaces= (n*2)-2;
        for(int i=1;i<=(n*2)-1;i++){
            if(i>n){

//                System.out.println(spaces);
                for(int j=1;j<=n-(i-n);j++){
                    System.out.print("*");
                }
                for(int k=1;k<=spaces;k++){
                    System.out.print(" ");
                }
                for(int j=1;j<=n-(i-n);j++){
                    System.out.print("*");
                }
                System.out.println();
                spaces=spaces+2;
            }else{
                for(int j=1;j<=i;j++){
                    System.out.print("*");
                }
                for(int k=1;k<=spaces;k++){
                    System.out.print(" ");
                }
                for(int j=1;j<=i;j++){
                    System.out.print("*");
                }
                System.out.println();
                if(spaces!=0){
                    spaces=spaces-2;
                }else{
                    spaces=spaces+2;
                }


            }
        }
    }

    /*
     *        *
     **      **
     ***    ***
     ****  ****
     **********
     **********
     ****  ****
     ***    ***
     **      **
     *        *
     */
    public static  void pattern25(){
        int n=scan.nextInt();
        int spaces=(n*2)-1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int k=1;k<spaces;k++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
            spaces=spaces-2;
        }
        spaces=0;
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            for(int k=1;k<=spaces;k++){
                System.out.print(" ");
            }
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
            spaces=spaces+2;
        }

    }
    public static  void pattern26(){
       int n=scan.nextInt();
       for(int i=1;i<=n;i++){
           for(int j=1;j<=n;j++){
               if(i==1||i==n||j==1||j==n){
                   System.out.print("*");
               }else{
                   System.out.print(" ");
               }
           }
           System.out.println();
       }

    }








}
