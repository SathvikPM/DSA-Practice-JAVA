package com.practice;

public class Revision {

    static int count=1;

    public static void main(String[] args) {
        int n=5;
//        printNumbers1(n);
//        printNumbers2(n);
//        reversePrinting(5);
//        int sum=0;
//        SumOfTheNumbers(n,sum);
//        factorial(5);


            System.out.println(fibo(5));


    }
    //printing numbers 1 to 5 using recursion
    public static void printNumbers1(int n){
        if(n<count){
            System.out.println("1st completed");
            return;
        }
        System.out.println(count);
        count++;
        printNumbers1(n);

    }

    //printing numbers using recursion and backtracking
    public static void printNumbers2(int n){
        if(n==0){
            System.out.println("2nd started");
            return;
        }
        printNumbers2(n-1);
        System.out.println(n);

    }

    public static void reversePrinting(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        n--;
        reversePrinting(n);
    }

    public static void SumOfTheNumbers(int n,int sum){
       if(n==0){
           System.out.println(sum);
           return;
       }
       sum=sum+n;
       SumOfTheNumbers(n-1,sum);

    }
    static  int fact=1;
    public static void factorial(int n){
        if(n==0){
            System.out.println(fact);
            return;
        }
        fact=fact*n;
        n=n-1;
        factorial(n);
    }

    public void printfibonocciSeries(int n){
        int first=0;
        int second=1;
        int next=0;
        for(int i=0;i<=n;i++){
            System.out.print(first+" ");
            next=first+second;
            first=second;
            second=next;
        }
    }

    public static int fibo(int n){
      int first=0;
      int second=1;
      int next=0;
      for(int i=2;i<n;i++){
          next=first+second;
          first=second;
          second=next;
      }
      return next;

    }









}
