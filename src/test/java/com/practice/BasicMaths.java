package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicMaths {

    static final Scanner scan=new Scanner(System.in);

    public static void main(String[] args) {
//        countDigits();
//        countDigitsWhichDividesNum( 7);
//        reverse(1534236469);
        isPalindrome(-121);
        isEven(2);
        getTable(9);
        findSum(10);

    }
    /*
    Given an integer num, return the number of digits in num that divide num.
    An integer val divides nums if nums % val == 0.

    Input: num = 7
    Output: 1
    Explanation: 7 divides itself, hence the answer is 1.
     */
    public static int countDigitsWhichDividesNum(int num) {
        int count=0;
        int originalNumber=num;
        while(num!=0){
            int last=num%10;
            if(originalNumber%last==0){
                count++;

            }
            num=num/10;
        }
        return count;

    }
    /*
    You are given an integer n.
    You need to return the number of digits in the number.
     */
    public static void countDigits(){
        int n=scan.nextInt();
        int count=0;
        while(n!=0){
            n=n/10;
            count++;
        }
        System.out.print(count);
    }

    /*
    Given a signed 32-bit integer x, return x with its digits reversed.
     If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     */
    public static int reverse(int x) {

        int rev=0;
        int last;
        while(x!=0){
            last=x%10;
            if (!(rev >= Integer.MIN_VALUE/10 && rev <= Integer.MAX_VALUE/10)) {
                return 0;
            }
            rev=rev*10+last;
            x=x/10;
        }
        return rev;


    }
   //Given an integer x, return true if x is a palindrome, and false otherwise.
    public static boolean  isPalindrome(int x) {
        int temp=x;
        int last=0;
        int rev=0;
        while(x>0){
            last=x%10;
            rev=rev*10+last;
            x=x/10;
        }
        if(rev==temp){
            return true;
        }else{
            return false;
        }

    }
    /*
    Given a positive integer n, determine whether it is odd or even.
    Return true if the number is even and false if the number is odd.
     */
    static boolean isEven(int n) {
        // code here
        if(n%2==0){
            return true;
        }
        return false;
    }
    /*
    Create the multiplication table from 1 to 10 for a given number n
     and return the table as an array.
     */
    static ArrayList<Integer> getTable(int n) {
        // code here
        ArrayList<Integer> list=new ArrayList<>(10);
        for(int i=1;i<=10;i++){
            list.add(n*i);
        }
        return list;

    }
    public static int findSum(int n) {
        // code here
        int sum=n*(n+1)/2;

        return sum;
    }
    /*
    Given an integer n. The task is to
    calculate the sum of the squares of the first  n natural numbers
     */

    public int sumOfSquares(int number) {
        // code here
        int sum=0;
        // for(int i=1;i<=number;i++){
        //     sum=sum+(i*i);
        // }

        //optimise solution
        sum=number*(number+1)*(2*number+1)/6;
        return sum;


    }

    /*
   You are given two numbers a and b.
    Your task is to swap the given two numbers.(With temp)
    */
    static List<Integer> swap(int a, int b) {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        int temp=a;
        a=b;
        b=temp;
        result.add(a);
        result.add(b);
        return result;
    }

    /*
   You are given two numbers a and b.
    Your task is to swap the given two numbers.(With out using temp)
    */
    static List<Integer> swap2(int a, int b) {
        // code here
        ArrayList<Integer> result=new ArrayList<>();

        a=a+b;
        b=a-b;
        a=a-b;
        result.add(a);
        result.add(b);
        return result;
    }










}
