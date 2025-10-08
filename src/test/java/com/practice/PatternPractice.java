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
        printNumberPattern2();
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







}
