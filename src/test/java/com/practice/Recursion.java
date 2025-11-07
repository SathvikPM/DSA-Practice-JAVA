package com.practice;

public class Recursion {
    static  int count=1;

    public static void main(String[] args) {
        printNumbers(5);
        printNumbers2(5);
        printNumbers3(5); //backtracking
    }
    public static void printNumbers(int n){
        if(count>n){
            System.out.println("finished method 1");
            count=1;
           return;
        }
        System.out.println(count);
        count++;
        printNumbers(n);
    }
    public  static  void printNumbers2(int n){
        if(n==0){
            System.out.println("finished method 2");
            return;
        }
        System.out.println(count);
        count++;
        printNumbers2(n-1);
    }
    public static void printNumbers3(int n){
        if(n==0){
            System.out.println("Stated printing of backtracking method");
            return;
        }
        printNumbers3(n-1);
        System.out.println(n);//prints while returning
    }
}
