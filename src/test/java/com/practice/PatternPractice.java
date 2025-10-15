package com.practice;

import java.util.Scanner;

public class PatternPractice {

     static  final Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {

//        printSquareStarPattern();
//        printSquareNumberPattern();
//         printHallowSquarePattern();
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
        printReverseRightAngleTraiangle2();
          printReversePyramid();
    }

    public static void printSquareStarPattern(){

        int n=scan.nextInt();
        for(int i=1;i<=5;i++){
            for (int j=1;j<=5;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }

    }
    public static void printSquareNumberPattern(){

        int n=scan.nextInt();
        for(int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
    public static  void printHallowSquarePattern(){
        int n=scan.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==1 || i==n || j==1 || j==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static  void printHallowSquareNumbers(){
        int n=scan.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==1 || i==n || j==1 || j==n){
                    System.out.print(i);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void printNumberPattern(){
        int n=scan.nextInt();
        int count=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(count<10){
                    System.out.print("0");
                }
                System.out.print(count+" ");

                count++;
            }
            System.out.println();
        }
    }
    public static void printNumberPattern2(){
        int n=scan.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i*j<10){
                    System.out.print("0");
                }
                System.out.print(i*j+" ");
            }
            System.out.println();
        }
    }

    public static void printNumberPattern3(){
        int n=scan.nextInt();
        //method 1
        for(int i=1;i<=n;i++){
            int count=i;
            for(int j=1;j<=n;j++){
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
        System.out.println("Method2");
        //method 2(Efficent)
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(i+j-1+" ");

            }
            System.out.println();
        }
    }

    public static  void printRightTraiangle(){
        int n=scan.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }

    public static  void printRightTraiangleNum(){
        int n=scan.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static  void printRightTraiangleCount(){
        int n=scan.nextInt();
        int count=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }

    public static  void printReverseRightAngleTraiangle(){
        int n=scan.nextInt();
        for(int i=1;i<=n;i++){

            //for spaces
            for(int k=1;k<=n-i;k++){
                System.out.print(" ");
            }
            //for stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static  void printPyramid(){
        int n=scan.nextInt();
        for(int i=1;i<=n;i++){
            for(int k=1;k<=n-i;k++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }

    public  static  void printRightAngleTranglewithSpaces(){
        int n=scan.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(j==1||i==n||i==j){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public  static  void printHallowPyramid(){
        int n=scan.nextInt();

        for(int i=1;i<=n;i++){
            //for spaces
            for(int k=1;k<=n-i;k++){
                System.out.print(" ");
            }
           //for stars
            for(int j=1;j<=n;j++){
                if(j==1||i==5||i==j){
                    System.out.print("*"+" ");
                }else{
                    System.out.print("  ");
                }

            }
                System.out.println();
        }

    }
    public static void printReverseRightAngleTraiangle2(){
        int n=scan.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
    public  static  void printReversePyramid(){
        int n=scan.nextInt();
        for(int i=0;i<n;i++){
            for(int k=0;k<=i;k++){
                System.out.print(" ");
            }
            for(int j=0;j<n-i;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }

    }


















}
