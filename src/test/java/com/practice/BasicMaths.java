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
        oppositeFaceOfDice(6);
        closestNumber(13,4);
        nthTermOfAP(1,2,3);

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
    /*
    Input: n = 6
    Output: 1
    Explanation: For dice facing number 6 opposite face will have the number 1.
     */
    static int oppositeFaceOfDice(int n) {
        // code here
        return 7-n;
    }

    /*
            Input: n = 13, m = 4
        Output: 12
        Explanation: 12 is the closest to 13, divisible by 4.

        Input: n = -15, m = 6
        Output: -18
        Explanation: Both -12 and -18 are closest to -15, but -18 has the maximum absolute value.
     */
    static int closestNumber(int n, int m) {
        // code here
        int leftCount=0;
        int leftResult=0;
        for(int i=n;Integer.MIN_VALUE<=i;i-- ){
            if(i%m==0){
                leftResult=i;
                break;
            }
            leftCount++;
        }
        int rightCount=0;
        int rightResult=0;
        for(int i=n;i<=Integer.MAX_VALUE;i++){
            if(i%m==0){
                rightResult=i;
                break;
            }
            rightCount++;
        }
        if(leftCount==rightCount){
            return (Math.abs(leftResult) > Math.abs(rightResult)) ? leftResult : rightResult;
        }
        if(leftCount<rightCount){
            return leftResult;
        }
        return rightResult;
    }
    /*
    Input: a1 = 2, a2 = 3, n = 4
    Output: 5
    Explanation: The series is: 2,3,4,5,6.... Thus, the 4th term is 5.
     */
    public static int nthTermOfAP(int a1, int a2, int n) {
        // code here
        int dif=a2-a1;
        int res=a1;
        for(int i=1;i<n;i++){
            res=res+dif;
        }
        return res;



    }
    //optimised
    public static int nthTermOfAPopt(int a1, int a2, int n) {
        int d = a2 - a1;          // common difference
        return a1 + (n - 1) * d;  // formula
    }

    /*
    Given two positive integers x and y, determine if y is a power of x.
     If y is a power of x, return True. Otherwise, return False.

    Examples:

    Input: x = 2, y = 8
    Output: True
    Explanation: 23 is equal to 8.
     */

    public boolean isPowerOfAnother(int X, int Y) {
        // code here
        int res=1;
        if(Y==1){
            return true;
        }
        for(int i=0;i<=Y;i++){
            res=res*X;

            if(res==Y){
                return true;
            }
        }
        return false;
    }


 /*
 Given a positive number n. Find the sum of all the digits of n.

    Examples:

    Input: n = 687
    Output: 21
    Explanation: Sum of 687's digits: 6 + 8 + 7 = 21
  */
    static int sumOfDigits(int n) {
        // code here
        int sum=0;
        int last=0;
        while(n>0){
            last=n%10;
            sum=sum+last;
            n=n/10;
        }
        return sum;
    }
   /*
   You are given an integer n. Your task is to reverse the digits, ensuring that the reversed number has no leading zeroes.
    Examples:
    Input: n = 122
    Output: 221
    Explanation: By reversing the digits of number, number will change into 221.
    */
    public int reverseDigits(int n) {
        // Code here
        int last=0;
        int res=0;
        while(n!=0){
            last=n%10;
            res=res*10+last;
            n=n/10;
        }
        return res;
    }











}
